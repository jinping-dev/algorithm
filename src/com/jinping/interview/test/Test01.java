package com.jinping.interview.test;

import java.util.*;

/**
 * @Classname Test01
 * @Description
 * 把List
 * [
 * {"id":1,"name":"总部","pid":0},
 * {"id":2,"name":"技术部","pid":1},
 * {"id":3,"name":"产品设计部","pid":1},
 * {"id":4,"name":"产品部","pid":3},
 * {"id":5,"name":"风控部","pid":2},
 * {"id":6,"name":"信息安全部","pid":2},
 * ]
 * 其中pid为父级部门的id，把此List转换成Map,key为pid value为每个pid对应的全部部门，包含跨级的子部门
 * 例如
 * {
 *     0:[1,2,3,4,5,6],
 *     1:[2,3,4,5,6],
 *     2:[5,6],
 *     3:[4],
 * }
 * @Date 2020/12/23 11:09 上午
 * @Created by jinping
 */
public class Test01 {

    public static void main(String[] args) {
        Person person1 = new Person(1,"总部",0);
        Person person2 = new Person(2,"总部",1);
        Person person3 = new Person(3,"总部",1);
        Person person4 = new Person(4,"总部",3);
        Person person5 = new Person(5,"总部",2);
        Person person6 = new Person(6,"总部",2);
        List list = new ArrayList();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        Map map = getMap(list);
        System.out.println(map);

    }

    public static Map<Integer, List<Integer>> getMap(List<Person> personList){
        Map<Integer, List<Integer>> result = new HashMap<>();
        Set<Integer> pidSet = new TreeSet<>();
        for (Person person:personList){
            pidSet.add(person.getPid());
        }
        for (Integer pid:pidSet){
            result.put(pid,new ArrayList<>());
        }
        Iterator<Integer> iterator = result.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            putList(result.get(key),key,personList);
        }
        return result;
    }

    public static void putList(List<Integer> list,Integer pid,List<Person> personList){
        Person tempPerson = null;
        for(Person person:personList){
            if (person.getPid() == pid){
                tempPerson = person;
                list.add(person.getId());
            }
        }
        if (tempPerson!= null && tempPerson.getId() != pid){
            putList(list,tempPerson.getId(),personList);
        }
    }


}
