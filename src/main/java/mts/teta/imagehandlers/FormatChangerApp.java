package mts.teta.imagehandlers;

import mts.teta.ImageProcessor;

import java.util.concurrent.Callable;

public class FormatChangerApp extends ConsoleAttributes implements Callable<Integer> {

    public FormatChangerApp(ConsoleAttributes consoleAttributes) {
        this.inputFile = consoleAttributes.inputFile;
        this.outputFile = consoleAttributes.outputFile;
        this.format = consoleAttributes.format;
    }

    @Override
    public Integer call() throws Exception {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(this);
        return 0;
    }
}
