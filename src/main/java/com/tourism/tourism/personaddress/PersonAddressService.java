package com.tourism.tourism.personaddress;

import com.tourism.tourism.personaddress.exceptions.PersonAddressBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PersonAddressService {
  @Autowired
  private PersonAddressRepository personAddressRepository;

  public void validatePersonAddress(PersonAddress personAddress) {
    if (Objects.isNull(personAddress.getCountry())) {
      throw new PersonAddressBadRequestException("Person address without country.");
    }
    if (Objects.isNull(personAddress.getState())) {
      throw new PersonAddressBadRequestException("Person address without state.");
    }
    if (Objects.isNull(personAddress.getCity())) {
      throw new PersonAddressBadRequestException("Person address without city.");
    }
  }

  public PersonAddress findByCountryAndStateAndCity(String country, String state, String city) {
    Optional<PersonAddress> personAddress = personAddressRepository.findByCountryAndStateAndCity(country, state, city);
    if (personAddress.isPresent()) {
      return personAddress.get();
    } else {
      return null;
    }
  }
}
