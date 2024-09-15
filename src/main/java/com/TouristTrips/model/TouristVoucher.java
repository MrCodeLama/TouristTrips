package com.TouristTrips.model;

public class TouristVoucher {
    private int id;
    private VoucherType type;
    private String country;
    private int days;
    private int nights;
    private VoucherTransport transport;
    private Hotel hotel;
    private double cost;

    public TouristVoucher() {
        hotel = new Hotel();
    }

    public TouristVoucher(int id, VoucherType type, String country, int days, int nights, VoucherTransport transport, Hotel hotel, double cost) {
        this.id = id;
        this.type = type;
        this.country = country;
        this.days = days;
        this.nights = nights;
        this.transport = transport;
        this.hotel = hotel;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public VoucherTransport getTransport() {
        return transport;
    }

    public void setTransport(VoucherTransport transport) {
        this.transport = transport;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TouristVoucher{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", days=" + days +
                ", nights=" + nights +
                ", transport='" + transport + '\'' +
                ", hotel=" + hotel +
                ", cost=" + cost +
                '}';
    }
}

