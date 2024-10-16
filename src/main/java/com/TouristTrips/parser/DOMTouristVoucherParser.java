package com.TouristTrips.parser;

import com.TouristTrips.model.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DOMTouristVoucherParser extends AbstractTouristVoucherParser {
    @Override
    public List<TouristVoucher> parse(String xmlFilePath) {
        List<TouristVoucher> vouchers = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("TouristVoucher");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    TouristVoucher voucher = new TouristVoucher();
                    voucher.setId(Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent()));
                    voucher.setType(VoucherType.valueOf(element.getElementsByTagName("Type").item(0).getTextContent()));
                    voucher.setCountry(element.getElementsByTagName("Country").item(0).getTextContent());
                    voucher.setDays(Integer.parseInt(element.getElementsByTagName("Days").item(0).getTextContent()));
                    voucher.setNights(Integer.parseInt(element.getElementsByTagName("Nights").item(0).getTextContent()));
                    voucher.setTransport(VoucherTransport.valueOf(element.getElementsByTagName("Transport").item(0).getTextContent()));
                    voucher.setCost(Double.parseDouble(element.getElementsByTagName("Cost").item(0).getTextContent()));

                    // Обробка Hotel
                    NodeList hotelList = element.getElementsByTagName("Hotel");
                    if (hotelList.getLength() > 0) {
                        Element hotelElement = (Element) hotelList.item(0);
                        Hotel hotel = new Hotel();
                        hotel.setStars(Integer.parseInt(hotelElement.getElementsByTagName("Stars").item(0).getTextContent()));
                        hotel.setFood(HotelFood.valueOf(hotelElement.getElementsByTagName("Food").item(0).getTextContent()));
                        hotel.setRoomType(Integer.parseInt(hotelElement.getElementsByTagName("RoomType").item(0).getTextContent()));
                        hotel.setTv(Boolean.parseBoolean(hotelElement.getElementsByTagName("TV").item(0).getTextContent()));
                        hotel.setAirConditioning(Boolean.parseBoolean(hotelElement.getElementsByTagName("AirConditioning").item(0).getTextContent()));
                        hotel.setWifi(Boolean.parseBoolean(hotelElement.getElementsByTagName("WiFi").item(0).getTextContent()));
                        hotel.setMinibar(Boolean.parseBoolean(hotelElement.getElementsByTagName("Minibar").item(0).getTextContent()));
                        hotel.setBalcony(Boolean.parseBoolean(hotelElement.getElementsByTagName("Balcony").item(0).getTextContent()));
                        hotel.setParking(Boolean.parseBoolean(hotelElement.getElementsByTagName("Parking").item(0).getTextContent()));
                        voucher.setHotel(hotel);
                    }
                    vouchers.add(voucher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vouchers;
    }
}
