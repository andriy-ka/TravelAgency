package andriy.kachur.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "username")
    private String username;
    @Column(name = "data")
    private Date data;
    @Column(name = "bookedrooms")
    private int bookedrooms;

    public Order(){

    }

    public Order(int order_id, String username, Date data, int bookedrooms) {
        this.order_id = order_id;
        this.username = username;
        this.data = data;
        this.bookedrooms = bookedrooms;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getBookedrooms() {
        return bookedrooms;
    }

    public void setBookedrooms(int bookedrooms) {
        this.bookedrooms = bookedrooms;
    }

}
