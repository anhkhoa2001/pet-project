package org.example.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ABaseModel {

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "CREATE_AT")
    private Long createAt;

    @Column(name = "UPDATE_AT")
    private Long updateAt;

}
