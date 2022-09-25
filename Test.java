/*
1. 定义学生类
2. 主界面的代码编写
3. 添加学生的代码编写
4. 查看学生的代码编写
5. 删除学生的代码编写
6. 修改学生的代码编写

主界面的代码编写
思路：
用输出语句完成主界面的编写
用Scanner实现键盘录入数据
用switch语句完成操作的选择
用循环完成再次回到主界面

删除/修改学生学号不存在问题
思路：
1. 在删除/修改学生操作前，对学号是否存在进行判断
    1.1 如果不存在，显示提示信息
    1.2 如果存在，执行删除/修改操作
 */

package com.student.main;

import com.student.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        //主界面的代码编写
        //1. 用输出语句完成主界面的编写
        lo:
        while(true){
            //2. 用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            String select = scan.next();

            switch (select){
                case "1":
                    //System.out.println("添加学生");
                    addStudent(list);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(list);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent(list);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break lo;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        //1. 给出提示信息（请输入您要修改的学号）
        System.out.println("请输入您要修改的学生学号：");

        //2. 键盘接收要修改的学号
        Scanner scan = new Scanner(System.in);
        String updateSid = scan.next();

        //3. 调用getIndex方法，查找该学号在结合中出现的索引位置
        int index = getIndex(list, updateSid);

        //4. 根据索引位置判断，学号在集合中是否存在
        if (index == -1){
            //不存在：给出提示
            System.out.println("查无信息，请重新输入");
        }else{
            //存在：接收新的学生信息
            System.out.println("请输入新的学生姓名：");
            String name = scan.next();
            System.out.println("请输入新的学生年龄：");
            int age = scan.nextInt();
            System.out.println("请输入新的学生生日：");
            String birthday = scan.next();

            //封装为新的学生对象
            Student stu = new Student(updateSid, name, age, birthday);

            //调用集合的set方法，完成修改
            list.set(index, stu);

        }
    }

    //获取id索引的方法
    public static int getIndex(ArrayList<Student> list, String sid){
        //1.假设传入的学号在集合中不存在
        int index = -1;

        //2. 遍历集合，获得每一个学生对象，准备进行查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);

            //3. 获取每个学生对象的学号
            String id = stu.getSid();

            //4.使用获取出的学生学号，和传入的学号（查找的学号）进行比对
            if (id.equals(sid)){
                //存在：让index变量记录正确的索引位置
                index = i;
                break;
            }
        }
        //不存在：返回-1
        return index;
    }

    public static void deleteStudent(ArrayList<Student> list) {
        //1. 给出提示信息（请输入您要删除的学号）
        System.out.println("请输入您要删除的学生学号：");

        //2. 键盘接收要删除的学号
        Scanner scan = new Scanner(System.in);
        String deleteSid = scan.next();

        //3. 调用getIndex方法，查找该学号在结合中出现的索引位置
        int index = getIndex(list, deleteSid);

        //4. 根据索引位置判断，学号在集合中是否存在
        if (index == -1){
            //不存在：给出提示
            System.out.println("查无信息，请重新输入");
        }else{
            //存在：删除
            list.remove(index);
            System.out.println("删除成功");
        }

    }

    //添加查看学生的方法
    public static void queryStudent(ArrayList<Student> list) {
        /*查看学生的代码编写
        思路：
        1. 用键盘录入选择查看所有学生信息
        2. 定义一个方法，用于查看学生信息
            2.1 显示表头信息
            2.2 将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
        3. 调用方法
         */
        Scanner scan = new Scanner(System.in);

        //判断集合中是否存在数据，如果不存在直接给出提示
        if (list.size() == 0){
            System.out.println("无信息，请添加后重新查询");
            return;
        }

        //存在：展示表头数据
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t生日");

        //集合遍历，获取每个学生对象的信息，打印在控制台
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getBirthday());
        }
    }

    //添加学生的方法
    public static void addStudent(ArrayList<Student> list) {
        /*
        添加学生的代码编写
        思路：
        1. 用键盘录入选择添加学生
        2. 定义一个方法，用于添加学生
            2.1 显示提示信息，提示要输入何种信息
            2.2 键盘录入学生对象所需要的数据
            2.3 创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
            2.4 将学生对象添加到集合中（保存）
            2.5 给出添加成功提示
        3. 调用方法
         */
        Scanner scan = new Scanner(System.in);

        //1. 用键盘录入选择添加学生
        String sid;
        //1. 用键盘录入选择添加学生
        while(true) {
            System.out.println("请输入学号：");
            sid = scan.next();

            int index = getIndex(list, sid);

            if(index == -1){
                //sid不存在，学号可以使用
                break;
            }

            System.out.println("学号已占用，请重新输入");
        }
        
        System.out.println("请输入姓名：");
        String name = scan.next();
        
        System.out.println("请输入年龄：");
        int age = scan.nextInt();
        
        System.out.println("请输入生日：");
        String birthday = scan.next();

        //2. 定义一个方法，用于添加学生
        Student stu = new Student(sid, name, age, birthday);

        //3. 将封装好的学生对象，添加到集合容器当中
        list.add(stu);

        //4. 给出添加成功的提示信息
        System.out.println("添加成功！");
    }
}
