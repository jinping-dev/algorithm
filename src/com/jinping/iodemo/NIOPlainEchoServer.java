package com.jinping.iodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Classname NIOPlainEchoServer
 * @Description NIO demo
 * @Date 2020/11/21 12:08 下午
 * @Created by jinping
 */
public class NIOPlainEchoServer {
    public void server(int port) throws IOException {
        System.out.println("Listening for connects on port:" + port);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket ss = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        //将serversocket绑定到指定的端口里
        ss.bind(address);
        //设置为非阻塞状态，阻塞模式下注册操作是不允许的，会抛出异常
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //将channel注册到Selector里，并说明让Selector关注的点，这里是关注建立连接这个事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            try {
                //阻塞等待就绪的Channel，即没有与客户端连接建立连接前就一直轮询
                selector.select();
            }catch (IOException ex){
                ex.printStackTrace();
                break;
            }
            //获取到Selector里所有就绪的SelectedKey实例，每讲一个channel注册到一个selector就会产生一个SelectedKey
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //将就绪的SelectionKey从selector移除，因为马上要去处理它，防止重复执行
                iterator.remove();
                try {
                    //若selectedKey处于Acceptable状态
                    if (key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //接受客户端的连接
                        SocketChannel client = server.accept();
                        System.out.println("Accept cnnection from :" + client);
                        client.configureBlocking(false);
                        //向selector注册socketchannel，主要关注读写，并传入一个ByteBuffer实例供读写缓存
                        client.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    //若SelectedKey处于可读状态
                    if (key.isReadable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        //从channel里读取数据存入ByteBuffer里面
                        client.read(output);
                    }
                    if (key.isWritable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        //将bytebuffer里的数据写入到channel里面
                        client.write(output);
                        output.compact();
                    }
                }catch (IOException ex){
                    key.channel();
                    try {
                        key.channel().close();
                    }catch (IOException xex){
                    }
                }
            }
        }
    }
}
