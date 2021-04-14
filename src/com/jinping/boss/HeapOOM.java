package com.jinping.boss;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jinping
 * @DATE: 2021/4/13 23:01
 * @Description 测试oom异常
 * 参数：-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 **/
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
