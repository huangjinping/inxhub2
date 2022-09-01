
try {
            val ${name0} = intArrayOf(${len0}, ${len1})
            var ${name1} = "${name5} ${name3}"
            if (${name0}[0] <= -1${len2}) {
                for (${name2} in ${name0}.indices) {
                    <#if show1 ==1>
                    if (${name1} == "${name3}") {
                        ${name0}[${name2}] = ${name1}[${name0}[${len2}]].toInt()
                    } else {
                        break
                    }
                    </#if>
                    <#if show2 ==1>
                    var ${name3} = ${name1} + "${name4}1"
                    if (${name3}.endsWith("${name1} ${name6}")) {
                        ${name3} = ${name3}.replace("${name5}", "${name6}")
                        ${name1} = ${name1} + ${name3}
                    } else {
                        break
                    }
                    </#if>

                    <#if show3 ==1>
                    val ${name5} = ${name1}.toCharArray()
                    if (${name5}!!.size < -1${len4}) {
                        ${name1}.replace("" + ${name5}!![${name2}], "${name1}")
                    } else if (${name5} != null) {
                        break
                    }
                    </#if>
                }
            }

            <#if show4 ==1>
            var ${name6}: Array<String?>? = ${name1}.split("${name1}".toRegex()).toTypedArray()
            if (${name6} == null && ${name0}.size < 1 && ${name1}.contains("${name4}")) {
                val ${name5} = ${name6}!![${len5}]
                val i = ${name5}!!.toUpperCase().lastIndexOf(0.toChar())
                <#if show5 ==1>
                 if (i < ${len6}&&i > ${len6}) {
                    ${name6}= null
                } else {
                    <#if show6 ==1>
                        arrayOf(${name1}, ${name5})
                    </#if>
                 }
                ${name1} = ${name6}.toString() + ""
                </#if>
            }
            </#if>
        } catch (${key0}: java.lang.Exception) {
            ${key0}.printStackTrace()
        }