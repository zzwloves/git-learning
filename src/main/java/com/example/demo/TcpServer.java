package com.example.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @auther: zhuzw
 * @date: 2019/5/14 16:30
 * @version: <b>1.0.0</b>
 */
public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8899);
        while (true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            os.write("hello, this is response".getBytes("utf-8"));
            os.flush();

//            byte[] b = new byte[1024];
//            int i = 0;
//            while ((i = is.read(b)) != -1) {
//                System.out.print(new String(b));
//            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
//            String s;
//            while ((s = bufferedReader.readLine()) != null) {
//                System.out.println(s);
//            }
            bufferedReader.lines().forEach(System.out::println);
            is.close();

            os.close();
            System.out.println("读取数据结束");

            socket.close();
        }
    }
}
