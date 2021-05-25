package mts.teta;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import mts.teta.imagehandlers.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static marvinplugins.MarvinPluginCollection.scale;
import static marvinplugins.MarvinPluginCollection.crop;
import static marvinplugins.MarvinPluginCollection.gaussianBlur;

public class ImageProcessor {

    //BufferedImage в сигнатуре оставлена для прохождения существующего теста testTypoSourceName
    public void processImage(BufferedImage read, ResizerApp resizer) {

        MarvinImage image = MarvinImageIO.loadImage(resizer.getInputFile().getPath());
        scale(image.clone(), image, resizer.getResizeWidth(), resizer.getResizeHeight());
        MarvinImageIO.saveImage(image, resizer.getOutputFile().getPath());
    }

    public void processImage(QualityChangerApp qualityChanger) {

        MarvinImage image = MarvinImageIO.loadImage(qualityChanger.getInputFile().getPath());

        int qualityValue = qualityChanger.getQualityValue();
        int width = (int) ((qualityValue * 1f / 100) * image.getWidth());
        int height = (int) ((qualityValue * 1f / 100) * image.getHeight());

        scale(image.clone(), image, width, height);
        MarvinImageIO.saveImage(image, qualityChanger.getOutputFile().getPath());
    }

    public void processImage(CropperApp cropper) {

        MarvinImage image = MarvinImageIO.loadImage(cropper.getInputFile().getPath());
        crop(image.clone(), image, cropper.getCropX(), cropper.getCropY(), cropper.getCropWidth(), cropper.getCropHeight());
        MarvinImageIO.saveImage(image, cropper.getOutputFile().getPath());
    }

    public void processImage(BluerApp bluer) {

        MarvinImage image = MarvinImageIO.loadImage(bluer.getInputFile().getPath());
        gaussianBlur(image.clone(), image, bluer.getBlurRadius());
        MarvinImageIO.saveImage(image, bluer.getOutputFile().getPath());
    }

    public void processImage(FormatChangerApp formatChanger) throws IOException {

        BufferedImage bufferedImage1 = ImageIO.read(formatChanger.getInputFile());
        ImageIO.write(bufferedImage1, formatChanger.getFormat(), formatChanger.getOutputFile());
    }
}
