package com.maa.as5.as5.entity.dto.output;

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
public class CommentDto {
    private int id;
    private String content;
}
