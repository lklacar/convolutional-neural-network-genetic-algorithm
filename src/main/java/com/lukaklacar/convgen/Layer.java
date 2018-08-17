package com.lukaklacar.convgen;

import org.ejml.simple.SimpleMatrix;

public interface Layer {

    SimpleMatrix process(SimpleMatrix input);

}
