package org.liuz;


import org.liuz.phoneSys.data.PhoneData;
import org.liuz.phoneSys.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class NewData {
    public static void main(String[]args){
        List<Phone> list=new ArrayList();
        list.add(new Phone(1,"苹果","s4",3800,20));
        list.add(new Phone(2,"苹果","s5",5000,10));
        list.add(new Phone(3,"三星","note4",3800,13));
        list.add(new Phone(4,"三星","note5",4800,15));
        list.add(new Phone(5,"苹果","s6",6000,23));
        new PhoneData(list);
    }
}
