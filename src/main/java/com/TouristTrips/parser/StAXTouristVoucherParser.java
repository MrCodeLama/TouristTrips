package com.TouristTrips.parser;

import com.TouristTrips.model.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXTouristVoucherParser extends AbstractTouristVoucherParser {
    @Override
    public List<TouristVoucher> parse(String xmlFilePath) {
        List<TouristVoucher> vouchers = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(xmlFilePath));
            TouristVoucher voucher = null;
            Hotel hotel = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "TouristVoucher" -> voucher = new TouristVoucher();
                        case "ID" -> voucher.setId(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
                        case "Type" -> voucher.setType(VoucherType.valueOf(eventReader.nextEvent().asCharacters().getData()));
                        case "Country" -> voucher.setCountry(eventReader.nextEvent().asCharacters().getData());
                        case "Days" -> voucher.setDays(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
                        case "Nights" -> voucher.setNights(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
                        case "Transport" -> voucher.setTransport(VoucherTransport.valueOf(eventReader.nextEvent().asCharacters().getData()));
                        case "Cost" -> voucher.setCost(Double.parseDouble(eventReader.nextEvent().asCharacters().getData()));
                        case "Hotel" -> hotel = new Hotel();
                        case "Stars" -> hotel.setStars(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
                        case "Food" -> hotel.setFood(HotelFood.valueOf(eventReader.nextEvent().asCharacters().getData()));
                        case "RoomType" -> hotel.setRoomType(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
                        case "TV" -> hotel.setTv(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                        case "AirConditioning" -> hotel.setAirConditioning(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                        case "WiFi" -> hotel.setWifi(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                        case "Minibar" -> hotel.setMinibar(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                        case "Balcony" -> hotel.setBalcony(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                        case "Parking" -> hotel.setParking(Boolean.parseBoolean(eventReader.nextEvent().asCharacters().getData()));
                    }
                } else if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Hotel") && voucher != null) {
                        voucher.setHotel(hotel);
                    } else if (endElement.getName().getLocalPart().equals("TouristVoucher")) {
                        vouchers.add(voucher);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return vouchers;
    }
}
