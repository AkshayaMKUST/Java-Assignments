package com.example.calculation.controller;

import com.example.calculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculationController {

    @Autowired
    CalculationService calculationService;

    @GetMapping("/add")
    public double add(@RequestParam double num1,@RequestParam double num2){
        return calculationService.add(num1,num2);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1,@RequestParam double num2){
        return calculationService.subtract(num1,num2);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1,@RequestParam double num2){
        return calculationService.multiply(num1,num2);
    }

    @GetMapping("/division")
    public double division(@RequestParam double num1,@RequestParam double num2){
        return calculationService.division(num1,num2);
    }
}