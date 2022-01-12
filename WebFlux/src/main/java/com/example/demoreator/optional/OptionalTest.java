package com.example.demoreator.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    /**
     *         //Optional.of(T t): 创建一个Optional实例，t必须非空
     *         //Optional.empty(): 创建一个空的Optional实例
     *         //Optional.ofNullable(T t): t可以为null
     */


    @Test
    public void test1() {

        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);

        Girl girl2 = girl1.orElse(new Girl("xxx"));
        System.out.println(girl2);

    }

    @Test
    public void test2() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);

    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    // 优化以后的getGirlName()
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    // 使用Optional类的getGirlName()
    public String getGirlName2(Boy boy) {
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy xxx = boy1.orElse(new Boy(new Girl("xxx")));
        return xxx.getGirl().getName();
    }
}
