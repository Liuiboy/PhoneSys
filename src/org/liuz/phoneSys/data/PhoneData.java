package org.liuz.phoneSys.data;


import org.liuz.phoneSys.model.Phone;

import java.io.*;
import java.util.List;

/**
 * 运行时内存中保存数据,获取信息,已经及与本地文件数据交互.
 * @param <T>
 */
public class PhoneData<T> {
    /**数据文件*/
    private File file;
    /**Phone对象集合*/
    private List<T> list;
    /**
     *输入输出流
     */
    private OutputStream outputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;


    public PhoneData(){
        read();
    }
    public PhoneData(List<T> list){
        this.list=list;
        write();
    }

    {
        file = new File("resources/data.dat");

    }

    /**
     * 从本地文件读入数据
     */
    private void read() {
        try {
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            list = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回Phone
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 存储数据
     */
    public void write(){
        try{
            outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 查找
     */
    public Phone find(String type){
        for(Object n:list){
            if(((Phone)n).getType().equals(type)){
                return (Phone)n;
            }
        }
        return null;
    }


    /**
     * 删除
     */
    public boolean remove(String type){
        for(int i=0;i<list.size();i++){
            if(((Phone)list.get(i)).getType().equals(type)){
                list.remove(i);
                write();
               return true;
            }
        }
        return false;
    }

    /**
     * 查找找手机编号
     * @param id 手机编号
     * @return 是否找到该手机编号true or false
     */
    private boolean findId(int id){
        for(int i=0;i<list.size();i++){
            if(((Phone)list.get(i)).getId()==id){
                return true;
            }
        }
        return false;
    }

    /**
     * 打印数据-查看
     */
    public void showData(){
        read();
        System.out.println("编号 品牌\t型号\t单价\t库存");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    /**
     * 获取手机库中没有缺失的编号
     * @return 缺失的编号
     */
    public int randow(){
        for(int i=1;i<=1000;i++){
            if(!findId(i)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加手机,并保存在文件中
     * @param phone 手机对象
     */
    public void add(T phone){
        list.add(phone);
        write();
    }
    public static void main(String[] args) {
        (new PhoneData<Phone>()).showData();
    }


}
