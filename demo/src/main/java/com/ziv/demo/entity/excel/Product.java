package com.ziv.demo.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品导入实体
 *
 * @author ziv
 * @date 2020-10-15
 */
@Data
public class Product {

    /**
     * 产品名称
     */
    @ExcelProperty(index = 0, converter = SpecialStringConverter.class)
    private String productName;

    /**
     * 产品编号
     */
    @ExcelProperty(index = 1)
    private String productCode;

    /**
     * 价格
     */
    @ExcelProperty(index = 2)
    private BigDecimal price;

    /**
     * 库存
     */
    @ExcelProperty(index = 3)
    private Integer inventory;

    /**
     * 生产日期
     */
    @ExcelProperty(index = 4)
    private Date productionDate;
}
