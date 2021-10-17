//--------------start---------------
<EditText
        android:id="@+id/edt_${id}"
        <#if isWidth == 1>
        android:layout_width="match_parent"
        <#else>
        android:layout_width="${width}dp"
        </#if>
        android:layout_height="wrap_content"
        <#if isMargin == 1>
        android:layout_margin="${margin}dp"
        <#else>
        android:layout_marginLeft="${marginLeft}dp"
        android:layout_marginTop="${marginTop}dp"
<#--        android:layout_marginEnd="${marginEnd}dp"-->
<#--        android:layout_marginRight="${marginRight}dp"-->
        </#if>
        <#if isBackground==1>
        android:background="#${backgroundColor}"
        </#if>
        <#if isHint==1>
        android:hint="${hint}"
        </#if>
        <#if isLayoutGravity==1>
        android:layout_gravity="center"
        </#if>
<#--        <#if isLines==1>-->
<#--        android:lines="${lines}"-->
<#--        android:maxLength="${maxLength}"-->
<#--        </#if>-->
        <#if isPadding==1>
         android:padding="${padding}dp"
        <#else>
<#--        android:paddingStart="${paddingStart}dp"-->
<#--        android:paddingTop="${paddingTop}dp"-->
<#--        android:paddingLeft="${paddingLeft}dp"-->
        android:paddingRight="${paddingRight}dp"
<#--        android:paddingEnd="${paddingEnd}dp"-->
        android:paddingBottom="${paddingBottom}dp"
        </#if>
        android:text="${text}"
        <#if isTextColor==1>
        android:textColor="#${textColor}"
        </#if>
        android:visibility="gone"></EditText>

//--------------end---------------
