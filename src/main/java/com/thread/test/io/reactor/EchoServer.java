package com.thread.test.io.reactor;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServer  implements Runnable{
    Selector selector;
    ServerSocketChannel serverSocket;

    public EchoServer() throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8081);
        serverSocket.socket().bind(address);
        System.out.println("服务开始监听"+ address);
        serverSocket.configureBlocking(false);

        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new AcceptorHandler());

    }




    @Override
    public void run() {

        while(!Thread.interrupted()){
            try {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()){
                    SelectionKey sk = it.next();
                    dispatch(sk);
                }
                keys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void dispatch(SelectionKey sk) {
        Runnable handler = (Runnable)sk.attachment();
        if (handler!= null){
            handler.run();
        }
        
    }

    private class AcceptorHandler implements Runnable{
        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if (channel != null) {
                   new EchoHandler(selector,channel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
