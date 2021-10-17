//--------------start---------------
<TextView
        android:id="@+id/${id}"
        android:layout_width="${width}dp"
        android:layout_height="${height}dp"
        android:visibility="gone"
        android:layout_gravity="center"
        <#if isMargin == 1>
        android:layout_margin="${margin}dp"
        <#else>
        android:padding="${padding}dp"
        </#if>
        android:text="${text}"></TextView>
//--------------end---------------
