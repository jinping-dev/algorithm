package com.jinping.iodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @Classname AIOPlainEchoServer
 * @Description AIO demo
 * @Date 2020/11/21 12:24 下午
 * @Created by jinping
 */
public class AIOPlainEchoServer {
    public void server(int port) throws IOException {
        System.out.println("Listening for connects on port:" + port);
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocketChannel.bind(address);
        final CountDownLatch latch = new CountDownLatch(1);
        //开始接收新的客户端请求，一旦一个客户端请求被接收，CompletionHandler就会被调用
        serverSocketChannel.accept(null, new CompletionHandler<java.nio.channels.AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(final AsynchronousSocketChannel result, Object attachment) {
                //一旦处理完成，再次接收新的客户端请求
                serverSocketChannel.accept(null,this);
                ByteBuffer buffer = ByteBuffer.allocate(100);
                //在channel里面植入一个读操作EchoCompletionHandler，一旦buffer有数据写入，
                result.read(buffer,buffer,new EchoCompletionHandler(result));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

                //若遇到异常，关闭channel
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });

    }

    private final class EchoCompletionHandler implements CompletionHandler<Integer,ByteBuffer> {

        private final AsynchronousSocketChannel channel;

        public EchoCompletionHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            attachment.flip();
            //在channel里面植入一个读操作Completionhandler，一旦channel有数据写入，CompletionHandler便会被唤醒
            channel.write(attachment,attachment, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (attachment.hasRemaining()){
                        //如果buffer里面还有内容，则再次触发写入操作将buffer里面的内容写入到channel中
                        channel.write(attachment,attachment,this);
                    }else{
                        attachment.compact();
                        //如果channel里面还有内容需要读入到buffer里，则再次触发写入操作将channel里的内容读入channel
                        channel.read(attachment,attachment,EchoCompletionHandler.this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
