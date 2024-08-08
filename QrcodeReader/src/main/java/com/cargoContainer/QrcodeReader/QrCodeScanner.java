package com.cargoContainer.QrcodeReader;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QrCodeScanner {
    public static void main(String[] args) {
        try {
            // Load QR code image file
            File file = new File("C:\\Users\\91968\\Desktop\\QRCodes\\trailer.png");
            BufferedImage bufferedImage = ImageIO.read(file);

            // Convert image to binary bitmap
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decode the QR code
            QRCodeReader qrCodeReader = new QRCodeReader();
            Result result = qrCodeReader.decode(bitmap);

            // Output the QR code content
            System.out.println("QR Code Content: " + result.getText());

        } catch (IOException | NotFoundException | ChecksumException | FormatException e) {
            e.printStackTrace();
        }
    }
}
