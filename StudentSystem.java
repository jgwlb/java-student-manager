package newa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class StudentSystem {
    private HashMap<String,Student> studentMap = new HashMap<>();
    private Scanner sc;

    public StudentSystem() {
        this.sc = new Scanner(System.in);
    }

    public void startStudentSystem() {
        while(true) {
            System.out.println("-----------------学生管理系统-------------------");
            System.out.println("1.添加学生 2.删除学生 3.修改学生 4.查询学生 5.退出");
            switch (this.sc.next()) {
                case "1":
                    this.addStudent();
                    break;
                case "2":
                    this.deleteStudent();
                    break;
                case "3":
                    this.updateStudent();
                    break;
                case "4":
                    this.queryStudent();
                    break;
                case "5":
                    System.out.println("退出系统，感谢使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请输入1-5选择功能");
            }
        }
    }

    private void addStudent() {
        System.out.println("请输入学号：");
        String id = this.sc.next();
        if (this.studentMap.containsKey(id)) {
            System.out.println("学号已存在，添加失败");
        } else {
            System.out.println("请输入姓名：");
            String name = this.sc.next();
            System.out.println("请输入年龄：");
            int age = this.sc.nextInt();
            System.out.println("请输入性别：");
            String gender = this.sc.next();
            Student student = new Student(id, name, age, gender);
            this.studentMap.put(id,student);
            System.out.println("添加完成");
        }
    }

    private void deleteStudent() {
        System.out.println("请输入要删除的学号：");
        String id = this.sc.next();
        if (!this.studentMap.containsKey(id)) {
            System.out.println("学号不存在，删除失败");
        } else {
            this.studentMap.remove(id);
            System.out.println("删除成功");
        }
    }

    private void updateStudent() {
        System.out.println("请输入要修改的学号：");
        String id = this.sc.next();
        if (!this.studentMap.containsKey(id)) {
            System.out.println("学号不存在，修改失败");
        } else {
            System.out.println("请输入新姓名：");
            String name = this.sc.next();
            System.out.println("请输入新年龄：");
            int age = this.sc.nextInt();
            System.out.println("请输入新性别：");
            String gender = this.sc.next();
            Student student = new Student(id, name, age, gender);
            this.studentMap.put(id, student);
            System.out.println("修改完成");
        }
    }

    private void queryStudent() {
        if (this.studentMap.isEmpty()) {
            System.out.println("暂无学生信息");
        } else {
            for(Student student : this.studentMap.values()) {
                System.out.println(student);
            }

        }
    }


}