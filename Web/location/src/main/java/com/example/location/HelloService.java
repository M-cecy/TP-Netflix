package com.example.location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloService {

    private List<Car> cars = new ArrayList<Car>();

    public HelloService() {
        cars.add(new Car("11AA22", "Ferrari", 1000));
        cars.add(new Car("33BB44", "Porshe", 2222));
        cars.add(new Car("11AA42", "BMW", 15000));
        cars.add(new Car("33BB94", "toyota", 22202));
    }
    @GetMapping("/cars")
    public List<Car> getListOfCars(){
        return cars;
    }

    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable(value = "plateNumber") String plateNumber){
        for(Car car: cars){
            if(car.getPlateNumber().equals(plateNumber)){
                return car;
            }
        }
        return null;
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public void rent(@PathVariable("plateNumber") String plaque,
                     @RequestParam(value="rent", required = true)boolean rented,
                     @RequestBody(required = false) Dates dates){
        System.out.println(plaque);
        System.out.println(rented);
        System.out.println(dates);

        if(rented == false){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        }
    }

    /**
     * comment transmettre les variables

    @GetMapping ("/cars/{plaque}")
    public void essai(@PathVariable(value = "plaque") String immatriculation) {
    }

    @GetMapping ("/cars/{plaque}/{debut}/(fin}")
    public void essai4(@PathVariable(value = "plaque") String immatriculation,@PathVariable(value = "debut") String debut,@PathVariable(value = "fin") String fin){
    }


    * comment transmettre dans la requette des dates
     * */

}
