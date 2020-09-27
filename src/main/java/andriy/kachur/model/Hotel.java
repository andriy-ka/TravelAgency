package andriy.kachur.model;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Indexed
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String country;
    @Column(name = "availableRooms")
    private int availableRooms;
    @Column(name = "rooms")
    private int rooms;


    public Hotel(){

    }

    public Hotel(int id, String name, String country, int availableRooms,int rooms) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.availableRooms = availableRooms;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", availableRooms=" + availableRooms +
                '}';
    }
}
