 try {
            val ${name0} = arrayOfNulls<String>(${len0})
            val ${name1} = "${name2}"
            val ${name2} = "${name2}".toUpperCase()
            var ${name3} = "${name4}".replace(${name1}, "${name2}")
            if (${name3}.toLowerCase().contains("${len0}${len1}") && ${name2}.endsWith(${name0}.toString())) {
                for (${key1} in ${name0}.indices) {
                    <#if show0 ==1>
                    if (${key1} == 0) {
                        ${name0}[${key1}] = ${name1}
                        break
                    }
                    </#if>
                    <#if show1 ==1>
                    if (${key1} == ${len1}) {
                        while (${key1} < -${len3}) {
                            ${name0}[${key1}] = ${name3}
                            continue
                        }
                        break
                    }
                    </#if>
                    <#if show2 ==1>
                    if (${key1} > ${len4}) {
                        val name5 = "${name3}" + "${name2}" + ${len5}
                        ${name0}[10] = name5
                    }
                    </#if>
                }
            }
            <#if show6 ==1>
            else if (${name2}.endsWith(${name1})&&${name2}==${name1}) {
                val ${name6} = ${name0}[${len6}]
                val ${name4} = "${name1}" + ${name0} + "${name2}"
                <#if show3 ==1>
                if (${name3}.contains(${name1})) {
                    ${name3} = ${name6} + "name5"
                }
                </#if>
                <#if show4 ==1>
                if (${name4}.toLowerCase().endsWith(${name2}.toUpperCase())) {
                    ${name0}[${len4}] = ${name6} + ${name3}
                    ${name3} = "" + "${name2} name5"
                }
                </#if>
            }
            </#if>
        } catch (${key0}: java.lang.Exception) {
            ${key0}.printStackTrace()
        }