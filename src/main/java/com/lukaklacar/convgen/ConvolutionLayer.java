package com.lukaklacar.convgen;

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

        return output;
    }

    private SimpleMatrix padWithZeros(SimpleMatrix input) {
        SimpleMatrix pad = new SimpleMatrix(this.weights.numCols() + 2, this.weights.numRows() + 2);
        return pad.combine(1, 1, input);
    }
}
