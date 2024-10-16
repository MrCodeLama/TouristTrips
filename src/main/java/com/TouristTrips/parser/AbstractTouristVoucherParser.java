package com.TouristTrips.parser;

import com.TouristTrips.model.TouristVoucher;
import java.util.List;

public abstract class AbstractTouristVoucherParser {
    // Абстрактний метод для парсингу файлу XML у список об'єктів TouristVoucher
    public abstract List<TouristVoucher> parse(String xmlFilePath);

    // Метод для валідації XML-файлу відповідно до схеми XSD
    public boolean validate(String xmlFilePath, String xsdFilePath) {
        try {
            javax.xml.validation.SchemaFactory factory = javax.xml.validation.SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            javax.xml.validation.Schema schema = factory.newSchema(new java.io.File(xsdFilePath));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new javax.xml.transform.stream.StreamSource(new java.io.File(xmlFilePath)));
            return true;
        } catch (Exception e) {
            System.out.println("Validation Error: " + e.getMessage());
            return false;
        }
    }
}
