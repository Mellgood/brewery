package it.bitesrl.brewery.web.controller;

import it.bitesrl.brewery.web.model.BeerDto;
import it.bitesrl.brewery.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postBeer(BeerDto beerDto){

        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo: add hostname to url
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return  new ResponseEntity(savedDto,headers, HttpStatus.CREATED);
    }
}
