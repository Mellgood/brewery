package it.bitesrl.brewery.services;

import it.bitesrl.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
