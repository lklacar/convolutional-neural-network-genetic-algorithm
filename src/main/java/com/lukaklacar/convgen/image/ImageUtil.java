package com.lukaklacar.convgen.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    public static ImageMatrix loadImage(String path) {
        try {
            BufferedImage img = ImageIO.read(new File(path));

            double[][] redChannel = new double[img.getWidth()][img.getHeight()];
            double[][] greenChannel = new double[img.getWidth()][img.getHeight()];
            double[][] blueChannel = new double[img.getWidth()][img.getHeight()];

            Raster r = img.getData();
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {

                    int rgb = img.getRGB(i, j);
                    Color c = new Color(rgb);

                    redChannel[i][j] = (double) c.getRed();
                    greenChannel[i][j] = (double) c.getGreen();
                    blueChannel[i][j] = (double) c.getBlue();
                }
            }

            return new ImageMatrix(img.getWidth(), img.getHeight(), redChannel, greenChannel, blueChannel);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeImage(ImageMatrix imageMatrix, String path) {


        BufferedImage bufferedImage = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < imageMatrix.getWidth(); i++) {
            for (int j = 0; j < imageMatrix.getHeight(); j++) {
                Color color = new Color(
                        (float) Math.min(imageMatrix.getRedChannel()[i][j] / 255.0f, 1),
                        (float) Math.min(imageMatrix.getGreenChannel()[i][j] / 255.0f, 1),
                        (float) Math.min(imageMatrix.getBlueChannel()[i][j] / 255.0f, 1)
                );
                bufferedImage.setRGB(i, j, color.getRGB());
            }
        }

        File outputFile = new File(path);
        try {
            ImageIO.write(bufferedImage, "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
