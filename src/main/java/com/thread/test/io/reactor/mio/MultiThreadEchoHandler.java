package com.thread.test.io.reactor.mio;



import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreadEchoHandler implements Runnable {
    final SocketChannel channel;
    final SelectionKey sk;
    final ByteBuffer buffer = ByteBuffer.allocate(1024);

    static final int RECIEVING = 0, SENDING = 1;

    int state = 0;

    static ExecutorService pool = Executors.newFixedThreadPool(4);

    public MultiThreadEchoHandler(Selector selector, SocketChannel c) throws IOException {
        channel = c;
        c.configureBlocking(false);
        sk = channel.register(selector, 0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        pool.execute(new AsyncTask());
    }


    public synchronized void asyncRun(){
        try {
            if (state == SENDING){
                channel.write(buffer);
                buffer.clear();
                sk.interestOps(SelectionKey.OP_READ);
                state = RECIEVING;
            }else if (state  == RECIEVING){
                int length = 0;
                while((length = channel.read(buffer))>0){
                    System.out.println(new String(buffer.array(),0,length));
                }

                buffer.flip();
                sk.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class AsyncTask implements Runnable {
        @Override
        public void run() {
            asyncRun();
        }
    }
}