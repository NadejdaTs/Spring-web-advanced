package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.exception.RouteNotFoundException;
import bg.softuni.pathfinder.models.Category;
import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.models.dto.view.RouteViewModel;
import bg.softuni.pathfinder.models.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.repositories.CategoryRepository;
import bg.softuni.pathfinder.repositories.RouteRepository;
import bg.softuni.pathfinder.services.RouteService;
import bg.softuni.pathfinder.services.UserService;
import bg.softuni.pathfinder.services.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RouteServiceImpl implements RouteService {
    private static final String BASE_GPX_COORDINATES_PATH = ".\\src\\main\\resources\\coordinates\\";
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ModelMapper mapper;
    private final LoggedUser loggedUser;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, UserService userService, ModelMapper mapper, LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.mapper = mapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = this.mapper.map(addRouteBindingModel, Route.class);
        String filePath = getFilePath(route.getName());

        try{
            File file = new File(BASE_GPX_COORDINATES_PATH + filePath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(addRouteBindingModel.getGpxCoordinates().getBytes());
            route.setGpxCoordinates(filePath);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);

        Optional<User> user = userService.getLoggedUser();
        route.setAuthor(user.get());

        String regex = "v=(.*)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(addRouteBindingModel.getVideoUrl());
        if(matcher.find()){
            String url = matcher.group(1);
            route.setVideoUrl(url);
        }

        routeRepository.save(route);
    }

    @Override
    public List<RouteViewModel> getAll() {
        return routeRepository.findAll().stream()
                .map(route -> mapper.map(route, RouteViewModel.class))
                .toList();
    }

    @Override
    public RouteDetailsViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));
//        mapper.createTypeMap(Route.class, RouteDetailsViewModel.class)
//                .addMappings(mapper -> mapper.map(r -> r.getAuthor().getUsername(), RouteDetailsViewModel::setAuthorName));
        RouteDetailsViewModel routeDetailsViewModel = mapper.map(route, RouteDetailsViewModel.class);
        routeDetailsViewModel.setAuthorName(route.getAuthor().getFullName());
//        return mapper.map(route, RouteDetailsViewModel.class);
        return routeDetailsViewModel;
    }

    private String getFilePath(String routeName) {
        String pathPattern = "%s\\%s_%s.xml";
        return String.format(pathPattern,
                loggedUser.getUsername(),
                transformFromRouteName(routeName),
                UUID.randomUUID());
    }

    private String transformFromRouteName(String routeName){
        return routeName.toLowerCase()
                .replaceAll("\\s+", "_");
    }
}
