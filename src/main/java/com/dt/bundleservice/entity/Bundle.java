package com.dt.bundleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bundle {
    private String id;
    private String packageName;
    private String title;
    private String description;
    private String marketUrl;
    private float rating;
    private String category;
    private Developer developer;
}
