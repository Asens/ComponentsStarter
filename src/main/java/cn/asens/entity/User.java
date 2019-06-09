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
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;



}
