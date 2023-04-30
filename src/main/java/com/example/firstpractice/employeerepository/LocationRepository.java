package com.example.firstpractice.employeerepository;

import com.example.firstpractice.employeedomein.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
