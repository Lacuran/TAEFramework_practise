package Entities;

import java.util.Objects;

public class Travellers {

    private int rooms;
    private int adults;
    private int child;
    private String nationality;

    public Travellers(int rooms, int adults, int child) {
        this.rooms = rooms;
        this.adults = adults;
        this.child = child;
    }

    public Travellers(int rooms, int adults, int child, String nationality) {
        this.rooms = rooms;
        this.adults = adults;
        this.child = child;
        this.nationality = nationality;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travellers that = (Travellers) o;
        return rooms == that.rooms && adults == that.adults && child == that.child && Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, adults, child, nationality);
    }

    @Override
    public String toString() {
        return "Travellers{" +
                "rooms=" + rooms +
                ", adults=" + adults +
                ", child=" + child +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
