try {
            var ${name0} = "${name0} ${name1}"
            val ${name2} = StringBuffer()
            <#if show0 ==1>
            if (${name0}.toUpperCase().startsWith("${name3}")) {
                <#if show2 ==1>
                ${name2}?.insert(${len3}, "${name1}")
                </#if>
                <#if show1 ==1>
                ${name2}?.append("${name2}")
                </#if>
                <#if show3 ==1>
                ${name2}?.reverse()
                </#if>
                <#if show4 ==1>
                ${name2}?.indexOf("${name3}")
                </#if>
            }
            </#if>

            if (${name0}.length == 1) {
                <#if show5 ==1>
                for (${key1} in 0 until ${name2}!!.length) {
                    <#if show2 ==1>
                    while (${key1} < -${len5}) {
                        if (${name2} == null) {
                            break
                        }
                        ${name0} = ${name2}.toString()
                    }
                    </#if>
                    <#if show3 ==1>
                    val ${name3} = "${name4} ${name5}${name0}"
                    ${name2}?.append(${name3})
                    </#if>
                }
                </#if>
                <#if show1 ==1>
                while (${name2}?.length < -${len0}) {
                    val ${name6} = "${name0} ${name2} ${name3}"
                    <#if show4 ==1>
                    if (${name2}?.length > 0) {
                        ${name2}?.append(${name6})
                        break
                    }
                    </#if>
                    <#if show4 ==1>
                    val ${name3} = ${name2}?.substring(${len1}, ${len2})
                    if (${name3}.toUpperCase().startsWith(${name0})) {
                        break
                    }
                    </#if>
                }
                </#if>
            }
        } catch (${key0}: java.lang.Exception) {
            ${key0}.printStackTrace()
        }