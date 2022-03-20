package com.tbd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.core.lab.TailBean;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.Tail;


/**
 * @author lairuofei
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_t")
public class Item extends BaseEntity {

    @AutoID
    private Long autoId;

    private String itemId;

    private String pic;

    private Double price;

    private Long stock;

    private Long sales;

    private String desc;

}
