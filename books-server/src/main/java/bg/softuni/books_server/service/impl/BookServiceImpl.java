package bg.softuni.books_server.service.impl;

import bg.softuni.books_server.model.dto.AuthorDTO;
import bg.softuni.books_server.model.dto.BookDTO;
import bg.softuni.books_server.model.entity.AuthorEntity;
import bg.softuni.books_server.model.entity.BookEntity;
import bg.softuni.books_server.repository.AuthorRepository;
import bg.softuni.books_server.repository.BookRepository;
import bg.softuni.books_server.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookServiceImpl::mapBookToDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {
        return this.bookRepository.findById(id)
                .map(BookServiceImpl::mapBookToDTO);
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Optional<AuthorEntity> authorOpt = authorRepository
                .findByName(bookDTO.getAuthor().getName());

//        if(authorOpt == null){
//            authorOpt = new AuthorEntity().setName(bookDTO.getAuthor().getName());
//            authorOpt = authorRepository.save(authorOpt);
//        }

        BookEntity newBook = new BookEntity()
                .setAuthor(authorOpt.orElseGet(() ->
                        authorRepository.save(new AuthorEntity().setName(bookDTO.getAuthor().getName()))))
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        newBook = bookRepository.save(newBook);
        return newBook.getId();
    }


    private static BookDTO mapBookToDTO(BookEntity bookEntity){
        AuthorDTO authorDTO = new AuthorDTO()
                .setName(bookEntity.getAuthor().getName());

        return new BookDTO()
                .setId(bookEntity.getId())
                .setAuthor(authorDTO)
                .setTitle(bookEntity.getTitle())
                .setIsbn(bookEntity.getIsbn());
    }
}
