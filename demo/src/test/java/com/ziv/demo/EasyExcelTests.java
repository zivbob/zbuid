package com.ziv.demo;

import com.alibaba.excel.EasyExcel;
import com.ziv.demo.entity.excel.Product;
import com.ziv.demo.entity.excel.ProductReadListener;
import com.ziv.demo.entity.excel.SpecialStringConverter;
import org.junit.jupiter.api.Test;

import java.io.File;

public class EasyExcelTests {

    @Test
    void testExcelRead() {
        File file = new File("E://easyExcel/prod.xlsx");
        // EasyExcel.read(file, Product.class, new ProductReadListener()).sheet(0).doRead();
        EasyExcel.read(file, Product.class, new ProductReadListener()).registerConverter(new SpecialStringConverter()).sheet(0).doRead();
    }
}
