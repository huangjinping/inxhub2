
//--------------start---------------
 try {
            int ${name} = ${len1};
            int ${key4} = ${len3};
            if (${name} < -${len4}) {
                StringBuffer ${key3} = new StringBuffer();
                String ${name2} = new String();
                String ${name4} = "${name2}";
                <#if show == 1 >
                ${name2} = "${name1} ${name3} ${key1}";
                </#if>
                <#if show1 == 1>
                while (${name2}.contains("${name4}")) {
                    <#if show4 == 1 >
                    ${key4} = ${name2}.indexOf("${key}", ${len});
                    </#if>
                    <#if show3 == 1 >
                    ${name4} = ${name2} + ${name4};
                    </#if>
                    break;
                }
                </#if>
                <#if show2 == 1>
                for (int i = 0; i < ${name4}.toCharArray().length; i++) {
                    char[] ${key1} = ${name4}.toCharArray();
                    ${key3}.append(${name2} + "${name2}");
                    ${key3}.append(${key1}[i]);
                }
                </#if>
                String ${name3} = ${name4}.substring(${key4});
                Log.d("${name3}", ${key3}.toString() + "${name4}" + ${name2});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//--------------end---------------
