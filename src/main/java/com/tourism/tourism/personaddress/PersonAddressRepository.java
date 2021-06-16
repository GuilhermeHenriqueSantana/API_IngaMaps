package com.tourism.tourism.personaddress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
    Optional<PersonAddress> findByCountryAndStateAndCity(String country, String state, String city);
}
