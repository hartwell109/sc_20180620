package com.cn.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class UserBase {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32)
    public String userId;

    @Column(unique = true, nullable = false, length = 40)
    public String username;

    @Column(length = 40)
    public String password;
}
