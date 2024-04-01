package com.example.calculation.service;

import org.springframework.stereotype.Service;
@Service
public class CalculationService {
    public double add(double num1, double num2) {
        return num1+num2;
    }
    public double subtract(double num1, double num2) {
        return num1-num2;
    }
    public double multiply(double num1, double num2) {
        return num1*num2;
    }
    public double division(double num1, double num2) {
        return num1/num2;
    }
}
