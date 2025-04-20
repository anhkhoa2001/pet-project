package com.example.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.model.ABaseModel;


@Entity
@Table(name = "LOG_MODEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogModel extends ABaseModel {

    @Id
    private String id;

    @Column(name = "REQUEST")
    private String request;

    @Column(name = "RESPONSE")
    private String response;

}
