package com.yzy.test;

public class BinOut {


    public static String toBinaryString(Integer i){
        String b = Integer.toBinaryString(i);
        int l;
        StringBuilder s= new StringBuilder();
        if ((l=32-b.length())>0){
            for (int i1 = 0; i1 < l; i1++) {
                s.append("0");
            }
        }
        s.append(b);
        int x,y;
        s.insert(x=4 ," ");
        s.insert((x=x+4)+(y=1) ," ");
        s.insert((x=x+4)+(++y) ," ");
        s.insert((x=x+4)+(++y) ," ");
        s.insert((x=x+4)+(++y) ," ");
        s.insert((x=x+4)+(++y) ," ");
        s.insert((x=x+4)+(++y) ," ");
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println("2022-07-11".substring(0,7));
    }

}
