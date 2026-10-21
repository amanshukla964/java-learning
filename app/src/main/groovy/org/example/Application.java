package org.example;

import org.example.bean.UserConfig;
import org.example.classes.Man;
import org.example.classes.Person;
import org.example.classes.PersonInvocationHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import java.lang.reflect.Proxy;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(Application.class, args);

//        UserConfig config =
//                context.getBean("userConfigBean", UserConfig.class);
//
//        System.out.println("Name: " + config.getName());
//        System.out.println("Class Name: " + config.getClassName());
//
//        Man mohan = new Man("Mohan", "30", "bhopal", "MP");
//
//        ClassLoader loader = mohan.getClass().getClassLoader();
//
//        Class[] interfaces = mohan.getClass().getInterfaces();
//
//        Person proxyMohan = (Person) Proxy.newProxyInstance(loader, interfaces, new PersonInvocationHandler(mohan));
//        proxyMohan.introduce(mohan.getName());
    }
}
