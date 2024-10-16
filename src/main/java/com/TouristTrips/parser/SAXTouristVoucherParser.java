package com.TouristTrips.parser;

import com.TouristTrips.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SAXTouristVoucherParser extends AbstractTouristVoucherParser {
    @Override
    public List<TouristVoucher> parse(String xmlFilePath) {
        List<TouristVoucher> vouchers = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                TouristVoucher voucher = null;
                Hotel hotel = null;
                StringBuilder content = new StringBuilder();

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("TouristVoucher")) {
                        voucher = new TouristVoucher();
                    } else if (qName.equalsIgnoreCase("Hotel")) {
                        hotel = new Hotel();
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    content.append(new String(ch, start, length));
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if (voucher != null) {
                        switch (qName) {
                            case "ID" -> voucher.setId(Integer.parseInt(content.toString().trim()));
                            case "Type" -> voucher.setType(VoucherType.valueOf(content.toString().trim()));
                            case "Country" -> voucher.setCountry(content.toString().trim());
                            case "Days" -> voucher.setDays(Integer.parseInt(content.toString().trim()));
                            case "Nights" -> voucher.setNights(Integer.parseInt(content.toString().trim()));
                            case "Transport" -> voucher.setTransport(VoucherTransport.valueOf(content.toString().trim()));
                            case "Cost" -> voucher.setCost(Double.parseDouble(content.toString().trim()));
                            case "Stars" -> hotel.setStars(Integer.parseInt(content.toString().trim()));
                            case "Food" -> hotel.setFood(HotelFood.valueOf(content.toString().trim()));
                            case "RoomType" -> hotel.setRoomType(Integer.parseInt(content.toString().trim()));
                            case "TV" -> hotel.setTv(Boolean.parseBoolean(content.toString().trim()));
                            case "AirConditioning" -> hotel.setAirConditioning(Boolean.parseBoolean(content.toString().trim()));
                            case "WiFi" -> hotel.setWifi(Boolean.parseBoolean(content.toString().trim()));
                            case "Minibar" -> hotel.setMinibar(Boolean.parseBoolean(content.toString().trim()));
                            case "Balcony" -> hotel.setBalcony(Boolean.parseBoolean(content.toString().trim()));
                            case "Parking" -> hotel.setParking(Boolean.parseBoolean(content.toString().trim()));
                            case "Hotel" -> voucher.setHotel(hotel);
                            case "TouristVoucher" -> vouchers.add(voucher);
                        }
                    }
                    content.setLength(0);  // Очищаємо буфер
                }
            };
            saxParser.parse(xmlFilePath, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vouchers;
    }
}
