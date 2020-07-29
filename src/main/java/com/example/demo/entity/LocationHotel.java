package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LocationHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String address;
    private  String district;
    private  String province;
    @OneToMany(mappedBy = "locationHotel", cascade = CascadeType.ALL)
    private List<Hotel> hotels;

}
