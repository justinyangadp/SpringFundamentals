package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config;

import javax.imageio.spi.RegisterableService;

class RegisterTest {

    //  TODO-09: Add a static field to hold a reference to the Register bean:
    private static Register registerBean;


    //  TODO-10: Add a static void method annotated with @BeforeAll.
    //  Instantiate the ApplicationContext using AnnotationConfigApplicationContext.
    //  (Reference the code you just completed in App.java for guidance.)
    //  Get the Register bean from the ApplicationContext.
    //  Assign the Register bean to the static field.
    @BeforeAll
    public static void uhh() {
        ApplicationContext spring = new AnnotationConfigApplicationContext(Config.class);
        registerBean = spring.getBean(Register.class);
    }


    //  TODO-11: Write a @Test method to verify the computeTotal method.
    //  Call the computeTotal method on the Register bean.
    //  Pass in a double value of 100.00.
    //  Use the assertThat method to verify that the result isEqualTo 105.00.
    //  Hint: assertThat( ... ).isEqualTo( ... )
    @Test
    public void test() {
        double total = registerBean.computeTotal(100.00f);
        assertThat(total).isEqualTo(105.00f);
    }



    //  TODO-12: Organize your imports.  Save your work.
    //  Run this test.  It should pass.
    //  Right
}
