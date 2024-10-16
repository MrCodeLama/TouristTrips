package com.TouristTrips;

import com.TouristTrips.model.StructureChanger;
import com.TouristTrips.model.TouristVoucher;
import com.TouristTrips.parser.AbstractTouristVoucherParser;
import com.TouristTrips.parser.DOMTouristVoucherParser;
import com.TouristTrips.parser.SAXTouristVoucherParser;
import com.TouristTrips.parser.StAXTouristVoucherParser;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Шляхи до файлів
        String xmlFilePath = "src/main/resources/ExcursionInItaly.xml";
        String xsdFilePath = "src/main/resources/TouristVoucher.xsd";

        // Створення об'єктів кожного парсера
        AbstractTouristVoucherParser saxParser = new SAXTouristVoucherParser();
        AbstractTouristVoucherParser domParser = new DOMTouristVoucherParser();
        AbstractTouristVoucherParser staxParser = new StAXTouristVoucherParser();

        // Валідація XML проти XSD
        if (saxParser.validate(xmlFilePath, xsdFilePath)) {
            System.out.println("XML файл успішно пройшов валідацію.");
        } else {
            System.out.println("Валідація не пройшла. Перевірте XML файл.");
             // Зупиняємо виконання програми, якщо валідація не пройшла
        }

        // Використання кожного парсера для перетворення XML у список об'єктів TouristVoucher
        System.out.println("\n--- SAX Parser ---");
        List<TouristVoucher> saxVouchers = saxParser.parse(xmlFilePath);
        displayVouchers(saxVouchers);

        System.out.println("\n--- DOM Parser ---");
        List<TouristVoucher> domVouchers = domParser.parse(xmlFilePath);
        displayVouchers(domVouchers);

        System.out.println("\n--- StAX Parser ---");
        List<TouristVoucher> staxVouchers = staxParser.parse(xmlFilePath);
        displayVouchers(staxVouchers);


        StructureChanger changer = new StructureChanger();
        changer.group("src/main/resources/ExcursionInItaly.xml", "src/main/resources/grouping.xsl");
    }
    private static void displayVouchers(List<TouristVoucher> vouchers) {
        System.out.println(vouchers);
    }
}