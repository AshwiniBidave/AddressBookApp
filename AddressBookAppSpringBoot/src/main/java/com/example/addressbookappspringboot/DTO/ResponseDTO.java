package com.example.addressbookappspringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class ResponseDTO {
    private String Msg;
    private Object Data;

}
