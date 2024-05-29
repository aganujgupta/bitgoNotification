package com.bitgo.Notification.Models;


import lombok.Data;

import java.util.List;

@Data
public class Notification {
    private String id;
    private float currentPrice;
    private float dailyPercentageChange;
    private long tradingVolume;
    private List<String> emailIdList;
    private Status status;
}
