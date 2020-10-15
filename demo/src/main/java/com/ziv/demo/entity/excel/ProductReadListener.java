package com.ziv.demo.entity.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

/**
 * 读取监听器
 *
 * @author ziv
 * @date 2020-10-15
 */
public class ProductReadListener extends AnalysisEventListener<Product> {

    private static final int BUFFER_SIZE = 10;

    private List<Product> buffer = new LinkedList<>();

    private int total = 0;

    @Override
    public void invoke(Product data, AnalysisContext context) {
        buffer.add(data);
        if (buffer.size() >= BUFFER_SIZE) {
            // TODO 数据持久化
            total += buffer.size();
            System.err.println("写入");
            buffer.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        total += buffer.size();
        System.err.println("总数据："+total);
        System.err.println("样例数据："+ JSON.toJSONString(buffer.get(0)));
        System.err.println("写入完成");
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        System.err.println("读取异常");
        exception.printStackTrace();
    }
}
