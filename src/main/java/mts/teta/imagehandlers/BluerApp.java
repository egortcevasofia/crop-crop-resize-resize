package mts.teta.imagehandlers;

import mts.teta.ImageProcessor;

import java.util.concurrent.Callable;

public class BluerApp extends ConsoleAttributes implements Callable<Integer> {

    public BluerApp(ConsoleAttributes consoleAttributes) {
        this.inputFile = consoleAttributes.inputFile;
        this.outputFile = consoleAttributes.outputFile;
        this.blurRadius = consoleAttributes.blurRadius;
    }

    @Override
    public Integer call() {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(this);
        return 0;
    }
}
