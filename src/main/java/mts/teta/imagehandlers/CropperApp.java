package mts.teta.imagehandlers;

import mts.teta.ImageProcessor;

import java.util.concurrent.Callable;

public class CropperApp extends ConsoleAttributes implements Callable<Integer> {

    public CropperApp(ConsoleAttributes consoleAttributes) {
        this.inputFile = consoleAttributes.inputFile;
        this.outputFile = consoleAttributes.outputFile;
        this.cropWidth = consoleAttributes.cropWidth;
        this.cropHeight = consoleAttributes.cropHeight;
        this.cropX = consoleAttributes.cropX;
        this.cropY = consoleAttributes.cropY;
    }

    @Override
    public Integer call() {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(this);
        return 0;
    }
}
