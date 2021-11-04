//--------------start---------------
try {
            String ${name} = "${name1}".getClass().getName();
            String ${key3} = ${name} + "${name3}";
            if (${name}.length() == 0) {
                String[] ${name4} = ${name}.split("11");
                <#if show1 ==1>
                for (String userList : ${name4}) {
                    ${key3} += userList;
                    <#if show3 ==1>
                    if (${key3}.length() > ${len}) {
                        ${key3} = "${name2}";
                    }
                    </#if>
                }
                </#if>
                <#if show ==1>
                while (${key3}.length() < -1) {
                    ${key3}+="${name3}";
                    break;
                }
                </#if>
                Log.d("${name4}",${key3}+ " ${name4} ");
            }
        } catch (Exception ${key5}) {
            ${key5}.fillInStackTrace();
        }
//--------------end---------------
