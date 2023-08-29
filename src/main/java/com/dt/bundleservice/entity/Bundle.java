package com.dt.bundleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
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
