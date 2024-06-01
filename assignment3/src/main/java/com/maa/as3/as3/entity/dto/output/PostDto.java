package com.maa.as3.as3.entity.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
}
