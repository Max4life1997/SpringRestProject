package com.example.demo.restGetController;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDataResponse {
    private int id;
    private String text;
}
