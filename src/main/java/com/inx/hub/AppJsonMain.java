package com.inx.hub;

import com.google.gson.Gson;
import com.inx.hub.bigJson.app466.FriedAuthorFastKnowledge;
import com.inx.hub.bigJson.app466.PinkFenceCentigradeEffort;

public class AppJsonMain {

    public static void main(String[] args) {
//        System.out.println("最大正整数: " + Long.MAX_VALUE);
//        System.out.println("最小负整数: " + Long.MIN_VALUE);
//        System.out.println("=========AppJson=======");
//        String textByPath = FileUtils.getTextByPath("/Users/huhuijie/Documents/GitHub/inxhub2/json/9001.json");
//        System.out.println("=========AppJson=======" + textByPath);
//        Gson gson = new Gson();
//        TightNestHumorousPrinting tightNestHumorousPrinting = gson.fromJson(textByPath, TightNestHumorousPrinting.class);
//
//        System.out.println("=========AppJson=======" + textByPath);

//        String ios="A0129254EE9C469BB1B07AA64F459C69";
//        String android="70c0b65b3a631a6d79864d038d816ce1";
//
//        System.out.println(android.length()+"=========AppJson=======" + android.length());


//        String textByPath = FileUtils.getTextByPath("/Users/huhuijie/Documents/GitHub/inxhub2/json/9002.json");
//        System.out.println("=========AppJson====0===" + textByPath);
//        Gson gson = new Gson();
//        DarkCounterRudeInterest tightNestHumorousPrinting = gson.fromJson(textByPath, DarkCounterRudeInterest.class);


//        System.out.println("=========AppJson====1===" + tightNestHumorousPrinting.toString());

        PinkFenceCentigradeEffort pinkFenceCentigradeEffort = new PinkFenceCentigradeEffort();
        FriedAuthorFastKnowledge author=new FriedAuthorFastKnowledge();

        pinkFenceCentigradeEffort.setFriedAuthorFastKnowledge(author);

        Gson gson = new Gson();
        System.out.println(gson.toJson(pinkFenceCentigradeEffort));


    }
}
