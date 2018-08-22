package com.lukaklacar.convgen.neuralnetwork.layers;

import com.lukaklacar.convgen.util.Dimension;
import org.ejml.simple.SimpleMatrix;

public class ConvolutionLayer implements Layer {

    private SimpleMatrix weights;

    public ConvolutionLayer(Dimension dimension) {
        this.weights = new SimpleMatrix(dimension.getWidth(), dimension.getHeight());
    }

    public SimpleMatrix process(SimpleMatrix input) {
        SimpleMatrix paddedInput = padWithZeros(input);
        SimpleMatrix output = new SimpleMatrix(input.numCols(), input.numRows());
        for (int i = 0; i < paddedInput.numCols() - weights.numCols() + 1; i++) {
            for (int j = 0; j < paddedInput.numRows() - weights.numRows() + 1; j++) {
                SimpleMatrix extractedFromInput = paddedInput.extractMatrix(i, i + weights.numCols(), j, j + weights.numRows());
                output.set(i, j, extractedFromInput.elementMult(weights).elementSum());
            }
        }

        System.out.println(output);
        return output;
    }

    private SimpleMatrix padWithZeros(SimpleMatrix input) {
        SimpleMatrix pad = new SimpleMatrix(this.weights.numCols() + 2, this.weights.numRows() + 2);
        return pad.combine(1, 1, input);
    }

    public SimpleMatrix getWeights() {
        return weights;
    }

    public void setWeights(SimpleMatrix weights) {
        this.weights = weights;
    }
}
