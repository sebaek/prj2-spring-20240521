package com.prj2spring20240521.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardFile {
    private String name;
    private String src;
}
