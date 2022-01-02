package com.thread.test.io.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class EchoHandler implements Runnable{
    final SocketChannel  channel;
    final SelectionKey  sk;

    static final int RECIEVING  = 0,SENDING = 1;

    int state = RECIEVING;
    private ByteBuffer buffer = ByteBuffer.allocate(1204);

    public EchoHandler(Selector selector, SocketChannel c) throws IOException {
        this.channel = c;
        c.configureBlocking(false);
        sk = channel.register(selector,0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();

    }

    @Override
    public void run() {
        try{
            if(state == SENDING) {
                channel.write(buffer);
                buffer.clear();
                sk.interestOps(SelectionKey.OP_READ);
                state = RECIEVING;
            }else if (state  == RECIEVING) {
                int length = 0;
                while((length = channel.read(buffer))> 0){
                    System.out.println(new String(buffer.array(),0,length));
                }

                buffer.flip();
                sk.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
