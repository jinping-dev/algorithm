package com.jinping.boss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Classname User
 * @Description User
 * @Date 2020/12/23 4:53 下午
 * @Created by tinner
 */
public class User {

    private Integer age;
    private Integer getAge(){
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer age) {
        this.age = age;
    }

    public static void remove(List<User> userList){
        userList.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 20;
            }
        });
    }

    public static void removeList(List<User> userList){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            if (next.getAge() > 20){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for(int i = 15 ;i < 23;i ++){
           User user = new User(i);
           users.add(user);
        }
        remove(users);
        System.out.println(users);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
