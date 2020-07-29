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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<ImageHotel> imageHotels;
    @ManyToOne
    @JoinColumn(name = "locatin_id")
    private LocationHotel locationHotel;
}
