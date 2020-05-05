package com.xiechy.reference;

import com.xiechy.User;

import java.io.IOException;

/**
 * 强引用，普通引用
 */
public class TestNormalReference {
    public static void main(String[] args) throws IOException {

        User  u = new User();
        u = null;
        System.gc();
        System.in.read();
    }
}
