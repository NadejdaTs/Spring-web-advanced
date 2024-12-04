package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.models.dto.view.RouteViewModel;
import bg.softuni.pathfinder.models.dto.binding.AddRouteBindingModel;

import java.util.List;

public interface RouteService {
    void add(AddRouteBindingModel addRouteBindingModel);

    List<RouteViewModel> getAll();

    RouteDetailsViewModel getDetails(Long id);
}
