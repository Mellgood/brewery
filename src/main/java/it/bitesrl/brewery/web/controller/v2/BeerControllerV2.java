package it.bitesrl.brewery.web.controller.v2;

import it.bitesrl.brewery.services.v2.BeerServiceV2;
import it.bitesrl.brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity (beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postBeer(BeerDtoV2 beerDto){

        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo: add hostname to url
        headers.add("Location", "/api/v2/beer" + savedDto.getId().toString());

        return  new ResponseEntity(savedDto,headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity putBeer(@PathVariable UUID beerId, BeerDtoV2 beerDto){

        BeerDtoV2 newBeerDto= beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteById(beerId);

    }
}
