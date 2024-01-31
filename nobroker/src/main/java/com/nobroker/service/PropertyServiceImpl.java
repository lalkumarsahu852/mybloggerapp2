package com.nobroker.service;


import com.nobroker.entity.Property;
import com.nobroker.payload.PropertyDTO;
import com.nobroker.repository.PropertyRepository;
import com.nobroker.util.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Property property = propertyMapper.propertyDtoToEntity(propertyDTO);
        property.setStatus("pending");
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.propertyEntityToDto(savedProperty);
    }

    @Override
    public PropertyDTO updatePropertyStatus(Long id, String newStatus) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Property not found"));

        property.setStatus(newStatus);
        Property updatedProperty = propertyRepository.save(property);
        return propertyMapper.propertyEntityToDto(updatedProperty);
    }

    @Override
    public String findPropertyById(long id) {
        Property property = propertyRepository.findById(id).get();
        return property.getStatus();
    }


}
