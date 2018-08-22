package com.lukaklacar.convgen.neuralnetwork.layers;

import org.ejml.simple.SimpleMatrix;

public class DenseLayer implements Layer {
    private SimpleMatrix weights;

    public SimpleMatrix process(SimpleMatrix input) {
        return input.mult(weights);
    }
}
