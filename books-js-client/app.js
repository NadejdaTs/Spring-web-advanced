let reloadBooksButton:HTMLElement = document.getElementById("reloadBooks")

reloadBooksButton.addEventListener("click", reloadBooks)

function reloadBooks(){
    let booksContainer:HTMLElement = document.getElementById('books-col')
    booksContainer.innerHTML = ""

    fetch("http://localhost:8080/api/books")
    .then(response:Response => response.json())
    .then(json => json.forEach(book => {
        let bookRow: HTMLTableRowElement = document.createElement("tr");

        let titleCol = document.createElement("td")
        let authorCol = document.createElement("td")
        let isbnCol = document.createElement("td")
        let actionCol = document.createElement("td")

        titleCol.textContent = book.title
        authorCol.textContent = book.author.name
        isbnCol.textContent = book.isbn

        let deleteBookBtn:HTMLElement = document.createElement("button")
        deleteBookBtn.innerHTML = "DELETE"
        deleteBookBtn.dataset.id = book.id
        deleteBookBtn.addEventListener("click", deleteBtnClick)


        bookRow.appendChild(titleCol)
        bookRow.appendChild(authorCol)
        bookRow.appendChild(isbnCol)
        bookRow.appendChild(actionCol)
        actionCol.appendChild("deleteBookBtn")

        booksContainer.append(bookRow)
    }))
}

function deleteBtnClick(event) : void {
    let bookId:string = event.target.dataset.id;
    let requestOptions:{method:string} = {
        method: "DELETE"
    }

    fetch(`http://localhost:8080/api/books/${bookId}`, requestOtions)
    .then(_ :Response => reloadBooks())
        .catch(error => console.log("error", error))
    alert("DELETE TRIGGERED FOR BOOK " + bookId)
}