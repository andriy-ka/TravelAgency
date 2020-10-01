package andriy.kachur.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "book")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "ordername")
    private String ordername;
    @Column(name = "email")
    private String email;
    @Column(name = "period")
    private Date date;
    @Column(name = "room")
    private int room;
    @Column(name = "hotel")
    private String hotel;


    public Order() {

    }

    public Order(int order_id, String ordername, String email, Date date, int room, String hotel) {
        this.order_id = order_id;
        this.ordername = ordername;
        this.email = email;
        this.date = date;
        this.room = room;
        this.hotel = hotel;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }


}