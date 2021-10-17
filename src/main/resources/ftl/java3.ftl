//--------------start---------------

         try {
                    <#if show4 ==1>
                    String ${name1} = Thread.currentThread().getName();
                    <#else>
                    String ${name1} = "${name3}";
                    </#if>
                    String ${name2} = "${name2}" + "${name1}";
                    int ${key} = ${len};
                    int ${key1} =${name1}.length();
                    String ${name3} = "${name1}";
                    String[] ${name4} = new String[${len3}];
                    if (${name2}.endsWith(${name1})) {
                        <#if show3 ==1>
                        switch (${key1}) {
                            case 1:
                                ${key} = ${name2}.split("[${name3}]").length;
                                break;
                            <#if show ==1>
                            case 2:
                                ${name3} = ${name4}[${key}];
                                break;
                            </#if>
                            <#if show1 ==1>
                            case 3:
                                ${name2} = ${name3} + ${key};
                                break;
                            </#if>
                            default:
                                ${name4}[${len1}] = ${name3} + ${key};
                        }
                        </#if>
                        ${name3} = ${key} + ${name3} + ${name2};
                        System.out.println(${name3});
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//--------------end---------------
