package com.example.auth.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.core.model.ABaseModel;

@EqualsAndHashCode(callSuper = true)
@Table(name = "G_WHITELIST")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GWhitelist extends ABaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "URL")
    private String url;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getUrl() {
        return url;
    }
}
