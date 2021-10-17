try {
            String ${name0} = "${name4} ${name3}";
            <#if show1 ==1>
            String ${name1} = "${key} ${key1} ${key2} ${key4}";
            <#else>
            String ${name1} = "${key4}";
            </#if>
            ${name0} = "${name1} ${name3}";
            if (${name0}.endsWith("1" + "${name4}")) {
                String ${name2} = ${name0}.substring(1);
                int ${key} = ${name0}.indexOf(${name2});
                char[] ${name4} = ${name0}.toCharArray();
                <#if show1 ==1>
                for (char ${name3} : ${name4}) {
                    <#if show4 ==1>
                    for (int j = 0; j < ${len1}; j++) {
                        ${name2} = ${name3} + "" + j + ${key};
                    }
                    </#if>
                }
                </#if>
                <#if show2 ==1>
                while (${key} < -${len}) {
                    ${name4}[${key}] = ${name1}.charAt(10);
                    <#if show3 ==1>
                    ${name0} = String.valueOf(${name1}.charAt(11)) +"${key1}";
                    </#if>
                    ${key}++;
                    break;
                }
                </#if>

                ${name0} = ${name2} + "${name4}";
                Log.d("${name2}", ${name1} + "${name}" + ${name4});
            }
            <#if show3 ==1>
            if (${name0}.startsWith("1" + "${name3}")) {
                String ${key2} = ${name0}.concat(${name1});
                Log.d("${name2}", ${key2} + "name" );
            }
            </#if>


        } catch (Exception e) {
            e.printStackTrace();
        }