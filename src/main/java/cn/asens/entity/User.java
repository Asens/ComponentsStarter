package cn.asens.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Asens on 2015/12/19
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String labels;

    @Column(name="user_image")
    private String userImage;
    @Column
    private String phone;
    @Column
    private String description;
    @Column
    private Integer gender;
    @Column
    private String job;

    @Column
    private Integer assets;


}
