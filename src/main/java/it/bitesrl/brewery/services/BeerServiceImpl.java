package it.bitesrl.brewery.services;

import it.bitesrl.brewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Guinness")
                .beerStyle("Black")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        //todo: would save the entity on a persistence layer
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        //todo: would save the entity on a persistence layer
        return null;
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo: would delete the entity on a persistence layer
        log.error("not implemented yet: deleting a beer...");
    }
}
