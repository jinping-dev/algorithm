package com.jinping.iodemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname BIOPlainEchoServer
 * @Description BIO demo
 * @Date 2020/11/21 12:00 下午
 * @Created by jinping
 */
public class BIOPlainEchoServer {

    public void server(int port) throws IOException {
        //将serverSocket绑定到指定的端口里
        final ServerSocket socket = new ServerSocket(port);
        while (true){
            //阻塞直到收到新的客户端连接
            final Socket clientSocket = socket.accept();
            System.out.println("接收连接从："+ clientSocket);
            //创建一个子线程去处理客户端的请求
            new Thread(new Runnable(){

                @Override
                public void run() {
                    try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
                        while (true){
                            printWriter.println(reader.readLine());
                            printWriter.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 用线程池的方式避免线程创建销毁的开销
     * @param port
     * @throws IOException
     */
    public void ImporovedServer(int port) throws IOException {
        //将serverSocket绑定到指定的端口里
        final ServerSocket socket = new ServerSocket(port);
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while (true){
            //阻塞直到收到新的客户端连接
            final Socket clientSocket = socket.accept();
            System.out.println("接收连接从："+ clientSocket);
            //将请求提交给线程池去执行
            executorService.execute(()->{
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
                    while (true){
                        printWriter.println(reader.readLine());
                        printWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
