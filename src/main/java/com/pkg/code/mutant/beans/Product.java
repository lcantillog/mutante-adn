package com.pkg.code.mutant.beans;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class  Product implements Serializable {
    private String id;
    private List<Variants> variants;
}
