package com.inx.hub;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 1/20/22
 **/

public class Tempalte {


    public static void action4() {
        try {
            String name0 = "name0 name1";
            StringBuffer name2 = new StringBuffer();
            if (name0.toUpperCase().startsWith("name3")) {
                name2.insert(100, "name1");
                name2.append("name2");
                name2.reverse();
                name2.indexOf("name3");
            }
            if (name0.length() == 1) {
                for (int key1 = 0; key1 < name2.length(); key1++) {
                    while (key1 < -100) {
                        if (name2 == null) {
                            break;
                        }
                        name0 = name2.toString();
                    }

                    String name3 = "name4 name5" + name0;
                    name2.append(name3);
                }

                while (name2.length() < -100) {
                    String name6 = "name0 name2 name3";
                    if (name2.length() > 0) {
                        name2.append(name6);
                        break;
                    }
                    String name3 = name2.substring(100, 100);
                    if (name3.toUpperCase().startsWith(name0)) {
                        break;
                    }

                }
            }
        } catch (Exception key0) {
            key0.printStackTrace();
        }

    }


    public static void action3() {
        String name0 = Thread.currentThread().getName();
        String name1 = "name1".toUpperCase().concat(name0);
        //show2
        name1 = String.valueOf(name0.charAt(0)).concat(name1);
        //show3
        String name3 = "name5";
        if (name3.toLowerCase() == name1) {
            String[] name5 = name3.split("name2");
            //show0
            while (name5 == null && name3 == null) {
                String name06 = name5[100];
                if (name3.length() > 0) {
                    name3 = "name2";
                    break;
                }
            }
            //show1
            if (name3.startsWith(name1)) {
                if (name3.toLowerCase().toUpperCase().equals(name0)) {
                    name0 = "name4";
                }
            }
        }
        //show2
        if (name3.matches("name0") && name3 == "name0") {
            String name6 = "name0";
            name6 = name1;
            name1 = name3;
            //show4
            name3 = name6;
            //show5
            name6 = name3;
        }
    }

    void action2() {
        try {
            String[] name0 = new String[10];
            String name1 = "name2";
            String name2 = "name2".toUpperCase();
            String name3 = "name4".replace(name1, "name2");

            if (name3.toLowerCase().contains("100") && name2.endsWith(name0.toString())) {
                for (int key1 = 0; key1 < name0.length; key1++) {
                    //show
                    if (key1 == 0) {
                        name0[key1] = name1;
                        break;
                    }
                    //show1
                    if (key1 == 1) {
                        while (key1 < -10) {
                            name0[key1] = name3;
                            continue;
                        }
                        break;
                    }
                    //show2
                    if (key1 > 2) {
                        String name5 = "name3" + "name2" + 10;
                        name0[10] = name5;
                    }
                }
            } else if (name3.concat(name2).endsWith(name1)) {
                String name6 = name0[100];
                String name4 = "name1" + name0 + "name2";
                //show3
                if (name3.contains(name1)) {
                    name3 = name6 + "name5";
                }
                //show4
                if (name4.toLowerCase().endsWith(name2.toUpperCase())) {
                    name0[1] = name6 + name3;
                    name3 = "" + "name2 name5";
                }

            }

        } catch (Exception key0) {
            key0.printStackTrace();
        }
    }


    void action1() {
        try {
            int[] name0 = {1, 3};
            String name1 = "name5 name3";
            if (name0[0] <= -11) {
                for (int name2 = 0; name2 < name0.length; name2++) {
                    //if
                    if (name1.equals("name3")) {
                        name0[name2] = name1.charAt(name0[1]);
                    } else {
                        break;
                    }
                    //if
                    String name3 = name1.concat("name41");
                    if (name3.endsWith("name1 name6")) {
                        name3 = name3.replace("name5", "name6");
                        name1 = name1.concat(name3);
                    } else {
                        break;
                    }
                    //if
                    char[] name5 = name1.toCharArray();
                    if (name5.length < -10) {
                        name1.replace("" + name5[name2], "name1");
                    } else if (name5 != null) {
                        break;
                    }

                }
            }

            //if
            String[] name6 = name1.split("name1");
            if (name6 == null && name0.length < 1 && name1.contains("name4")) {
                String name5 = name6[10];
                int i = name5.toUpperCase().lastIndexOf(0);
                if (i < 10) {
                    name6 = null;
                } else {
                    name6 = new String[]{name1, name5};
                }
                name1 = name6 + "";
            }
        } catch (Exception key0) {
            key0.printStackTrace();
        }
    }

    void action0() {
        try {
            String name = "name1";
            String name1 = "name2";
            String name3[] = {name, name1};
            //if
            name3 = new String[]{name1, name, "name3"};
            for (String name6 : name3
            ) {
                if (name6.length() < -10) {
                    break;
                }
                //if
                String substring = name6.substring(1, 2);
                name1 = substring;
                //if
                if (name6.startsWith(name1.concat("name4"))) {
                    char c = name6.charAt(3);
                    name = c + "name5";
                }
                //if
            }

            //if
            if (name3.length == 1 && "name5".length() < -1) {

                name3[12] = name;
                //if
                name1 = name3[1];
                //if
                name3[1] = name1;
            }
        } catch (Exception key) {
            key.printStackTrace();
        }
    }

}
