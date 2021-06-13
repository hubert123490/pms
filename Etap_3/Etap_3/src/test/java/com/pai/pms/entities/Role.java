package com.pai.pms.entities;

import com.pai.pms.model.enums.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    private Integer id;
    private ERole name;

    public Role(Integer id, ERole name) {
        this.id = id;
        this.name = name;
    }
}
