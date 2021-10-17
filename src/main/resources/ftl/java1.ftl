//--------------start---------------
try {
            String ${name} = "${name1}".getClass().getName();
            String UserName = ${name} + "${name3}";
            if (${name}.length() == 0) {
                String[] ${name4} = ${name}.split("11");
                <#if show1 ==1>
                for (String userList : ${name4}) {
                    UserName += userList;
                    <#if show3 ==1>
                    if (UserName.length() > ${len}) {
                        UserName = "${name2}";
                    }
                    </#if>
                }
                </#if>
                <#if show ==1>
                while (UserName.length() < -1) {
                    UserName+="${name3}";
                    break;
                }
                </#if>
                Log.d("User",UserName+ " ${name4} ");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
//--------------end---------------
