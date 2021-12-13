package com.example.lab4.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Locale;

@Entity
@NoArgsConstructor
@Table(name = "orders")
@ToString
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name="order_id")
    private Long orderid;
    
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="client_id", referencedColumnName = "id")
    private User client;

    @Getter
    @Setter
    @Column(name = "_comment")
    private String comment;
    
    @Getter
    @Setter
    private BigDecimal price;
    
    @Enumerated(value = EnumType.STRING)
    private Status status;
    
    @Getter
    @Setter
    private String content;
    
    public String getStatus() {
        
        return this.status.name();
    }
    
    public void setStatus(String status) {
        
        if (status == null || status == "")
            this.status = Status.CREATED;
        else
            this.status = Status.valueOf(status.toUpperCase(Locale.ROOT));
    }
    
    public Order(Long id, String comment, User client, BigDecimal price, String status, String content) {
        
        setOrderid(id);
        setComment(comment);
        setClient(client);
        setPrice(price);
        setStatus(status);
        setContent(content);
    }
    
    public Order(String comment, User client, BigDecimal price, String status, String content) {
        
        setComment(comment);
        setClient(client);
        setPrice(price);
        setStatus(status);
        setContent(content);
    }

    public Order(User client, String content){
        setClient(client);
        setContent(content);
        setStatus(null);
        setPrice(BigDecimal.ZERO);
    }
}
