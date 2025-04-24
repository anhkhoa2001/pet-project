package com.example.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.model.ABaseModel;

@Entity
@Table(name = "USER_MODEL")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserModel extends ABaseModel {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @Column(name = "USER_NAME")
    private String username;



}
