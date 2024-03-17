package org.srini;

public class ThreadDemo {

    public static void main(String[] args) {
        Sender sender = new Sender() ;
        SenderThread st1 = new SenderThread(sender, "HI") ;
        SenderThread st2 = new SenderThread(sender, "Srinivas") ;
        st1.start();
        st2.start();

        try{
            st1.join();
            st2.join();
        }catch (InterruptedException exception){
            throw new RuntimeException("threads interrupted") ;
        }
    }
}


class SenderThread extends  Thread{

    Sender sender ;
    String msg ;

    SenderThread(Sender sender, String msg){
        this.sender = sender ;
        this.msg = msg ;
    }

    @Override
    public void run() {
        sender.sendMsg(msg);
    }
}

class Sender{
    public void sendMsg(String msg){
        System.out.println("sending "+msg);
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sent "+msg);
    }
}
