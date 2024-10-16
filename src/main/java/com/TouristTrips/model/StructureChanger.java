package com.TouristTrips.model;

import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class StructureChanger {
    public void group(String XMLfilepath, String XSLTfilepath) throws Exception {
        // Створюємо новий екземпляр фабрики Saxon
        TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();

        // Завантажуємо XSLT файл
        Source xslt = new StreamSource(new File(XSLTfilepath));
        Transformer transformer = factory.newTransformer(xslt);

        // Вхідний XML файл
        Source xml = new StreamSource(new File(XMLfilepath));

        // Вихідний файл після трансформації
        transformer.transform(xml, new StreamResult(new File("src/main/output/output.xml")));


    }
}
