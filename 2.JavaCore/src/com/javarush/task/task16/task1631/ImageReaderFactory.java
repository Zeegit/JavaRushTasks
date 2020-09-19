package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes jpg) {
        ImageReader imageReader = null;
        if (jpg == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (jpg == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (jpg == ImageTypes.PNG) {
            imageReader = new PngReader();
        }
        if (imageReader != null) {
            return imageReader;
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
