try {
            var ${name0} = "${name1}"
            var ${name1} = "${name2}"
            <#if show ==1>
                var  ${name3} = arrayOf(${name1}, ${name0}, "${name3}")
            <#else>
                var ${name3} = arrayOf(${name0}, ${name1})
            </#if>
            for (${name6} in ${name3}) {
                <#if show5 ==1>
                if(${name3}[0]!=null){
                    break
                }
                </#if>
                if (${name6}.length > -${len4}) {
                    break
                }
                <#if show1 ==1>
                val ${key1} = ${name6}.substring(${len1}, ${len0})
                ${name1} = ${key1}
                </#if>
                <#if show2 ==1>
                if (${name6}.startsWith(${name1} + "${name4}")) {
                    val c = ${name6}[${len1}]
                    ${name0} = c.toString() + "${name5}"
                }
                </#if>
            }
        <#if show3 ==1>
            if (${name3}.size == 1 && name.length < -1) {
                ${name3}[${len3}] = ${name0}
                <#if show4 ==1>
                ${name1} = ${name3}[${len}]
                </#if>
                <#if show4 ==1>
                ${name3}[${len1}] = ${name1}
                </#if>
            }
        </#if>
        } catch (${key}: Exception) {
            ${key}.printStackTrace()
        }