package com.tbd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.core.annotatoin.Column;

import java.util.Date;

/**
 * @author lairuofei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseEntity {

    @Column("is_deleted")
    protected Boolean isDeleted;

    @Column("created_at")
    protected Date createdAt;

    @Column("updated_at")
    protected Date updatedAt;
}
