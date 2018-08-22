package com.lukaklacar.convgen.neuralnetwork.layers;

import org.ejml.simple.SimpleMatrix;

public interface Layer {

    SimpleMatrix process(SimpleMatrix input);

}
