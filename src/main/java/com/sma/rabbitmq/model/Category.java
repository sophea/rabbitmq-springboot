package com.sma.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Category.class)
public class Category implements Serializable {

    private String code;
    private String description;
}
