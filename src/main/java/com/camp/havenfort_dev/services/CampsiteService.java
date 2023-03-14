package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.Repositories.CampsiteRepo;
import com.camp.havenfort_dev.Repositories.EventRepo;
import com.camp.havenfort_dev.entities.Campsite;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

@Service
public class CampsiteService implements ICampsiteService{
   @Autowired
    CampsiteRepo campsiteRepo;
   @Autowired
    EventRepo eventRepo;
    @Override
    public Campsite addCampsite(Campsite campsite) {
        return campsiteRepo.save(campsite);
    }



    @Override
    public Campsite updateCampsite(Campsite campsite) {
        return campsiteRepo.save(campsite);
    }



    @Override
    public void deleteCampsite(Long id) {
        campsiteRepo.deleteById(id);

    }

//    @Override
//    public byte[] generateQRCode(Long idCampsite) throws WriterException, IOException {
//        Campsite campsite = campsiteRepo.findById(idCampsite).get();
//        String qrCodeData = "idCampsite:" + campsite.getIdCampsite().toString() + "distance" + campsite.getDistance() + "description" + campsite.getDescription();
//        String charset = "UTF-8";
//        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
//        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(new String(qrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE, 200, 200, hintMap);
//        Path path = FileSystems.getDefault().getPath("c://");
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//    }

    @Override
    public byte[] generateQRCode(Long idCampsite) throws WriterException, IOException {
        Campsite campsite = campsiteRepo.findById(idCampsite).get();
        String qrCodeData = "idCampsite:" + campsite.getIdCampsite().toString() + "distance" + campsite.getDistance() + "description" + campsite.getDescription();
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(new String(qrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE, 200, 200, hintMap);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);
        return baos.toByteArray();
    }




}
