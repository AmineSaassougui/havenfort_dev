package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Campsite;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface ICampsiteService extends Serializable {

    Campsite addCampsite(Campsite campsite);

    public Campsite updateCampsite(Campsite campsite);
    public void deleteCampsite(Long id);

    byte[] generateQRCode(Long idCampsite) throws WriterException, IOException;
}
