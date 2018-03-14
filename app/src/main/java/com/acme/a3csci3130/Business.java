package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Business implements Serializable {

    public  String uid;
    public  String name;
    public  String address;
    public  String number;
    public  String primary_business;
    public  String province;

    public Business()
    {}


    public Business(String uid, String name, String address,String number, String primary_business, String province){
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.number = number;
        this.primary_business = primary_business;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("address", address);
        result.put("number", number);
        result.put("primary_business", primary_business);
        result.put("province", province);

        return result;
    }
}