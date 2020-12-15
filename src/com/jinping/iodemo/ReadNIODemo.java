package com.jinping.iodemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname ReadNIODemo
 * @Description ReadNIODemo
 * @Date 2020/12/10 5:30 下午
 * @Created by tinner
 */
public class ReadNIODemo {

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("/Users/tinner/Desktop/1.log");
        FileChannel channel = stream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("限制是：" + buffer.limit() + ",容量是：" + buffer.capacity() + " ,位置是：" + buffer.position());
        int length = -1;
        while ((length = channel.read(buffer)) != -1){
            /*
             * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
             */
            buffer.clear();
            byte[] bytes = buffer.array();
            System.out.println("start..............");

            String str = new String(bytes, 0, length);
            System.out.println(str);
            //System.out.write(bytes, 0, length);

            System.out.println("end................");

            System.out.println("限制是：" + buffer.limit() + "容量是：" + buffer.capacity() + "位置是：" + buffer.position());

        }
    }
}
