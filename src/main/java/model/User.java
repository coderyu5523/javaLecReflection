package model;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.lang.annotation.Target;

@AllArgsConstructor
@ToString
public class User {
    private int number ;
    private String username ;
    private String password ;
    private String phone ;


}
