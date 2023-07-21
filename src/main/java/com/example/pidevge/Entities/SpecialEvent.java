package com.example.pidevge.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialEvent {
    private String id;
    private String eventName;
    private String eventAddress;
    private String eventDescription;
    private String url;
    private String organizerName;
    private String organizerDetails;
    private String country;
    private String category;
    private String date;
    private String startTime;
    private String endTime;
    private int ticketVacancy;
    private int price;
    //private List<SubEvent> subEvents;


}
