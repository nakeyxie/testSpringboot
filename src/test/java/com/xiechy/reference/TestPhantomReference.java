package com.xiechy.reference;

import com.xiechy.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用 只用在管理堆外内存
 */
public class TestPhantomReference {
    private static final List<Object> LIST = new LinkedList<>();

    private static final ReferenceQueue<User> QUEUE = new ReferenceQueue<User>();

    public static void main(String[] args) {
        //同时指定队列，和类型
        PhantomReference<User> phantomReference = new PhantomReference<>(new User(), QUEUE);

        new Thread(()->{
            while(true){
                LIST.add(new byte[1024 * 1024]);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();
        //相当于GC
        new Thread(()->{
            while(true){
                Reference<? extends User> poll = QUEUE.poll();
                if(poll != null){
                    System.out.println("---虚引用对象被jvm回收了---"+poll);
                }
            }
        }).start();

        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
