package org.softuni.mobilele.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDTO;
import org.softuni.mobilele.repository.BrandRepository;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
  private final BrandRepository brandRepository;

  public BrandServiceImpl(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  @Override
  public List<BrandDTO> getAllBrands() {

    return brandRepository.getAllBrands().stream()
            .map(brand -> new BrandDTO(
                    brand.getName(),
                    brand.getModels().stream()
                            .map(model -> new ModelDTO(model.getId(), model.getName()))
                            .sorted(Comparator.comparing(ModelDTO::name))
                            .collect(Collectors.toList())
            ))
            .sorted(Comparator.comparing(BrandDTO::name))
            .collect(Collectors.toList());
  }
}
