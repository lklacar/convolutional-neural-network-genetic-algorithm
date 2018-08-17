package com.lukaklacar.convgen.neuralnetwork.activation;

public class ReluActivationFunction implements ActivationFunction {
    public double function(double x) {
        return Math.max(0, x);
    }
}
