package com.cigniti.appledemo.entity;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class AppleTunes {
    private List<AppleTune> appleTunes;
}
