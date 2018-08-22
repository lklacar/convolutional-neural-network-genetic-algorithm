package com.lukaklacar.convgen.neuralnetwork;

import com.lukaklacar.convgen.neuralnetwork.layers.Layer;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.List;

public class ConvolutionalNeuralNetwork {

    private List<Layer> layers;

    public ConvolutionalNeuralNetwork() {
        this.layers = new ArrayList<Layer>();
    }

    public void addLayer(Layer layer) {
        this.layers.add(layer);
    }

    public SimpleMatrix compute(SimpleMatrix input) {
        for (Layer layer : this.layers) {
            input = layer.process(input);
        }
        return input;
    }

}