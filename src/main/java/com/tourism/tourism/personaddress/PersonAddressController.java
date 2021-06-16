package com.tourism.tourism.personaddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person-address")
public class PersonAddressController {
  @Autowired
  private PersonAddressService personAddressService;

  @GetMapping(path = "find-by/country-state-city")
  public PersonAddress findByCountryAndStateAndCity(@RequestParam(value = "country") String country,
                                                    @RequestParam(value = "state") String state,
                                                    @RequestParam(value = "city") String city) {
    return personAddressService.findByCountryAndStateAndCity(country, state, city);
  }
}
