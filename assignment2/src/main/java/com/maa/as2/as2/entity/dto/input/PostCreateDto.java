package com.maa.as2.as2.entity.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class PostCreateDto {
    private String title;
    private String content;
    private int authorId;
}
