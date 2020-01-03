package org.liuz.phoneSys.operation;


import org.liuz.phoneSys.data.PhoneData;
import org.liuz.phoneSys.model.Phone;

import java.util.Scanner;

public class PhoneSys {
    //输入Scanner
    private Scanner scanner=new Scanner(System.in);

    private PhoneData<Phone> phoneData;


    {
        System.out.println("===欢迎光临手机专卖店===");
        phoneData=new PhoneData();
    }

    /**
     * 打印开始菜单
     */
    public void home(){
        System.out.println("1.查看手机");
        System.out.println("2.添加手机");
        System.out.println("3.删除手机");
        System.out.println("4.退出");
    }

    /**
     * 添加手机
     */
    public void addPhone(){
        System.out.println("请输入您想要增加的手机型号:");
        String type=scanner.next();
        Phone phone;
        //检测库中是否有同型号手机
        if((phone=phoneData.find(type))==null){
            //无同型号手机时,创建phone
            phone=new Phone();
            phone.setType(type);
            System.out.print("请输入品牌:");
            phone.setBrand(scanner.next());
            System.out.print("请输入价格:");
            phone.setPrice(scanner.nextInt());
            System.out.print("请输入库存:");
            phone.setRepertory(scanner.nextInt());

            //获取库中没有的编号
            int index=phoneData.randow();
            //判断是否获取成
            if(index!=-1){
                phone.setId(index);
            }else{
                System.out.println("无效编号");
            }
            phoneData.add(phone);

        }else{
            //有同型号手机时
            System.out.println("您输入的手机型号已经存在了,无法添加,可以进行修改操作");
            System.out.print("请输入手机价格(原价:"+phone.getPrice()+"元):");
            phone.setPrice(scanner.nextInt());
            System.out.print("请输入库存(原库存:"+phone.getRepertory()+"):");
            phone.setRepertory(scanner.nextInt());
            phoneData.write();
        }


    }

    public void run(){

        int cmd;
        do{

            home();

            System.out.print("\n请选择:");
            cmd=scanner.nextInt();
            System.out.println("____________________________________");
            switch(cmd){
                //查看手机
                case 1:
                    phoneData.showData();
                    System.out.print("\n任意输入退出>>>");
                    scanner.next();
                    System.out.println("____________________________________");
                    break;
                 //添加手机
                case 2:
                    do {
                        addPhone();
                        System.out.print("\n是y否n继续:");
                    }while(scanner.next().equals("y"));
                    System.out.println("____________________________________");

                    break;
                //删除手机
                case 3:

                    do {
                        System.out.print("请输入要删除的手机型号:");
                        //删除并判断是否删除成功
                        if(phoneData.remove(scanner.next())){
                            //如果成功
                            System.out.println("删除成功!");
                        }else{
                            //如果不成功
                            System.out.println("删除失败!仓库中没有该类型手机.");
                        }
                        System.out.print("\n是y否n继续:");

                    }while(scanner.next().equals("y"));
                    System.out.println("____________________________________");
                    break;

                default:

            }


        }while(cmd!=4);

    }
}
