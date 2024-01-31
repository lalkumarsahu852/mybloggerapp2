package com.nobroker.repository;

import com.nobroker.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
