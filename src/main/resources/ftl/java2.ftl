//--------------start---------------
try {

            String ${name3} = "${name3}";
            <#if show4 ==1>
            String ${name2} = "${name2}";
            StringBuffer buffer = new StringBuffer();
            String ${name4} = "${name4}";
            String ${name1} = "${name}";
            <#else >
            String ${name1} = "${name}";
            StringBuffer buffer = new StringBuffer();
            String ${name2} = "${name2}";
            </#if>

            if (!(buffer instanceof StringBuffer)) {
                buffer.append("${name1}".getClass().getFields().toString());
                for (int i = 0; i < "${name2}".getClass().getFields().length; i++) {
                    <#if show1 ==1>
                    String ${key3}  = "${name3}".toString();
                    buffer.append(${key3}.toString());
                    </#if>
                    <#if show2 ==1>
                    ${name1} = ${name2} + ${name3};
                    </#if>
                    buffer.append(${name1});

                }
            }else {
                <#if show ==1>
                if (${name3}.length() < 2) {
                    char[] chars = ${name3}.toCharArray();
                    ${name1} = new String(chars);
                    ${name3}=${name1}+${name2}+chars.length;
                    Log.d("${name4}",String.valueOf(${name3}));
                }
                </#if>
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//--------------end---------------
