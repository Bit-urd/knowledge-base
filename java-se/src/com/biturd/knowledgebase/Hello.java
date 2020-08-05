package com.biturd.knowledgebase;

import java.util.Collections;
import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: a
 * @Author: Biturd
 * @Date: 2020-06-30 13:13
 */
class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("static A");
    }

}

class HelloB extends HelloA {

}

public class Hello {

    public boolean compare(List first, List second) {
        Collections.sort(first);
        Collections.sort(second);
        if (first.size() == second.size()) {
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i) != second.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}