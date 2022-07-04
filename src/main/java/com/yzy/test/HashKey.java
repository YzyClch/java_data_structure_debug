package com.yzy.test;

public class HashKey {
    HashKey(String name,String hashKey,String equalsTag){
        this.hashKey=hashKey;
        this.name=name;
        this.equalsTag=equalsTag;
    }
    public String equalsTag;
    public String hashKey;
    public String name;

    @Override
    public int hashCode() {
        return Integer.parseInt(hashKey,2);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HashMapDebug.HashKey)){
            return false;
        }
        return this.equalsTag.equals(((HashMapDebug.HashKey) o).equalsTag);
    }
}
