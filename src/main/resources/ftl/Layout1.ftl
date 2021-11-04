//--------------start---------------
<LinearLayout
        android:layout_width="match_parent"
        android:orientation="vertical"
        android:visibility="gone"
        android:padding="${padding}dp"
        android:layout_height="wrap_content">

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

        <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                <#if isPadding == 1>
                android:padding="${padding}dp"
                android:gravity="center"
                </#if>
                android:text="${text}"
                android:textColor="#${textColor1}"></TextView>

        <#if isGone1 == 1>
        <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:gravity="center"
                android:padding="${padding}dp"
                android:text="${text1}"
                android:textColor="#${textColor2}"></TextView>

        </#if>
        <#if isGone2 == 1>
        <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:gravity="center"
                android:layout_margin="${margin}dp"
                android:text="${text1}"
                android:textColor="#${textColor2}"></TextView>
        </#if>

    </LinearLayout>

</LinearLayout>
//--------------end---------------
