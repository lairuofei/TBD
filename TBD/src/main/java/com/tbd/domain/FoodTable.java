package com.tbd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author lairuofei
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_table_t")
public class FoodTable extends BaseEntity {

    @AutoID
    private Long autoId;

    private String tableId;

    private Long position;

    private String status;

}
