package com.tbd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_t")
public class Order implements Serializable {
//    private static final long serialVersionUID = 2L;
    @AutoID
    private Long autoId;

    private String orderId;

    private Long tableId;

}
