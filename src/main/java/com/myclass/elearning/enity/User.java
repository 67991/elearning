package com.myclass.elearning.enity;

import ch.qos.logback.classic.spi.LoggerContextVO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String fullname;
    private String avatar;
    private String phone;
    private String  addreess;

    @Column(name = "role_id")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Role role;
}
