package com.picpay.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Priority implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", insertable=false,updatable=false)
    private User id_user ;

    @Column(name= "priority")
    private int priority;
}
