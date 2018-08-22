package com.lukaklacar.convgen.neuralnetwork.layers;

import com.lukaklacar.convgen.neuralnetwork.activation.ActivationFunction;
import com.lukaklacar.convgen.neuralnetwork.activation.ReluActivationFunction;
import org.ejml.simple.SimpleMatrix;

public class ReluLayer implements Layer {

    private ActivationFunction activationFunction = new ReluActivationFunction();

    public SimpleMatrix process(SimpleMatrix input) {
        SimpleMatrix output = new SimpleMatrix(input.numRows(), input.numCols());
        for (int i = 0; i < input.numCols(); i++) {
            for (int j = 0; j < input.numRows(); j++) {
                output.set(j, i, activationFunction.function(input.get(j, i)));
            }
        }
        return output;
    }
}
