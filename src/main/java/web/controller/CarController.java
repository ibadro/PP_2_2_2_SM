package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if (count < 0){
            System.out.println(" number is positive ");
        } else { model.addAttribute("cars", carService.getCars(count));}
        return "cars";
    }


}