package com.example.demo.dataAccess.entities.decorator;

import com.example.demo.dataAccess.entities.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client implements ClientInterface{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date dob;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @Override
    public Integer getAge() {
        return null;
    }
}
