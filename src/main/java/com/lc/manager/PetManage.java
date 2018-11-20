package com.lc.manager;

import com.lc.entity.PetInfo;
import com.lc.service.PetService;
import com.lc.service.impl.PetServiceImpl;

import java.util.List;
import java.util.Scanner;

public class PetManage {

    PetService service = new PetServiceImpl();

    Scanner input = new Scanner(System.in);

    /**
     * 查看宠物信息
     */
    public void findPet(){
        List<PetInfo> pet = service.findPet();
        System.out.println("编号\t姓名\t种类\t性别\t生日\t\t\t\t\t\t描述");
        for (PetInfo petInfo : pet){
            petInfo.show();
        }
    }

    /**
     * 新增宠物信息
     */
    public void addPet(){
        try{
            PetInfo petInfo = new PetInfo();
            System.out.println("请输入新增宠物编号");
            petInfo.setPetId(input.nextInt());
            System.out.println("请输入宠物姓名");
            petInfo.setPetName(input.next());
            System.out.println("请输入宠物种类编号");
            petInfo.setPetBreed(input.nextInt());
            System.out.println("请输入宠物性别编号");
            petInfo.setPetSex(input.nextInt());
            System.out.println("请输入宠物生日");
            petInfo.setBirthday(input.next());
            System.out.println("请输入宠物描述");
            petInfo.setDescription(input.next());
            service.addPet(petInfo);
            System.out.println("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * 删除宠物信息
     */
    public void delPet(){
        try{
            System.out.println("请输入要删除的宠物编号");
            service.delPet(input.nextInt());
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * 修改宠物信息
     */
    public void modifyPet(){
        try{
            PetInfo petInfo = new PetInfo();
            System.out.println("请输入要修改的宠物姓名");
            petInfo.setPetName(input.next());
            System.out.println("请输入要修改的种类编号");
            petInfo.setPetBreed(input.nextInt());
            System.out.println("请输入要修改的性别编号");
            petInfo.setPetSex(input.nextInt());
            System.out.println("请输入要修改的宠物生日");
            petInfo.setBirthday(input.next());
            System.out.println("请输入要修改的宠物描述");
            petInfo.setDescription(input.next());
            System.out.println("请选择你要修改的宠物编号");
            petInfo.setPetId(input.nextInt());
            service.modifyPet(petInfo);
            System.out.println("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
