
        <#if show0 ==1>
        var ${name0} = Thread.currentThread().name
        <#else>
        var ${name0} = "${name0} ${name1}"
        </#if>
        <#if show1 ==1>
         var ${name1} = "${name1}".toUpperCase() + ${name0}
        <#else>
        var  ${name1} = ${name0}[0].toString() + "${name1}"
        </#if>
        var ${name3}: String? = "${name5} ${name6}"
        if (${name3}!!.toLowerCase() === ${name1}) {
            val ${name5} = ${name3}!!.split("${name2}".toRegex()).toTypedArray()
            <#if show2 ==1>
            while (${name5} == null && ${name3} == null) {
                val name06 = ${name5}!![${len0}]
                if (${name3}!!.length > ${len1}) {
                    ${name3} = "${name2}"
                    break
                }
            }
            </#if>
            <#if show3 ==1>
            if (${name3}!!.startsWith(${name1})) {
                if (${name3}!!.toLowerCase().toUpperCase() == ${name0}) {
                    ${name0} = "${name4}"
                }
            }
            </#if>

        }
        <#if show3 ==1>
        if (${name3}!!.contains("${name1}") && ${name3} === "${name0}") {
            var ${name6}: String? = "${name0}"
            ${name6} = ${name1}
            <#if show4 ==1>
            ${name1} = ${name3}
            </#if>
            <#if show5 ==1>
            ${name3} = ${name6}
            </#if>
            <#if show6 ==1>
            ${name6} = ${name3}
            </#if>
        }
        </#if>