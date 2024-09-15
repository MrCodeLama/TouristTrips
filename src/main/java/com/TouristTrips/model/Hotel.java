package com.TouristTrips.model;

public class Hotel {
    private int stars;
    private HotelFood food;
    private int roomType;
    private boolean tv;
    private boolean airConditioning;
    private boolean wifi;
    private boolean minibar;
    private boolean balcony;
    private boolean parking;

    public Hotel() {}

    public Hotel(int stars, HotelFood food, int roomType, boolean tv, boolean airConditioning, boolean wifi, boolean minibar, boolean balcony, boolean parking) {
        this.stars = stars;
        this.food = food;
        this.roomType = roomType;
        this.tv = tv;
        this.airConditioning = airConditioning;
        this.wifi = wifi;
        this.minibar = minibar;
        this.balcony = balcony;
        this.parking = parking;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public HotelFood getFood() {
        return food;
    }

    public void setFood(HotelFood food) {
        this.food = food;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "stars=" + stars +
                ", food='" + food + '\'' +
                ", roomType='" + roomType + '\'' +
                ", tv=" + tv +
                ", airConditioning=" + airConditioning +
                ", wifi=" + wifi +
                ", minibar=" + minibar +
                ", balcony=" + balcony +
                ", parking=" + parking +
                '}';
    }
}

