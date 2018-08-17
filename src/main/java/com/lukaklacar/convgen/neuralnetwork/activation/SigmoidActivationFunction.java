package com.lukaklacar.convgen.neuralnetwork.activation;

public class SigmoidActivationFunction implements ActivationFunction {

    public double function(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

}