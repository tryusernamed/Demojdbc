package com.lc.test;

import com.lc.manager.PetManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        PetManage petManage = new PetManage();
        try{
            do {
                System.out.println("*****欢迎来到花花宠物管理系统*****");
                System.out.println("1、查看宠物信息\t2、新增宠物信息\t3、删除宠物信息\t4、修改宠物信息\t5、退出");
                int choose = input.nextInt();
                switch (choose){
                    case 1:
                        petManage.findPet();
                        continue;
                    case 2:
                        petManage.addPet();
                        continue;
                    case 3:
                        petManage.delPet();
                        continue;
                    case 4:
                        petManage.modifyPet();
                        continue;
                    case 5:
                        System.out.println("欢迎光临");
                        System.exit(-1);
                        break;
                }
                break;
            }while (true);
        }catch (InputMismatchException e){
            System.err.println("请输入数字");
            e.printStackTrace();
        }catch (Exception e){
            System.err.println("网络异常");
            System.exit(-1);
        }
    }
}
