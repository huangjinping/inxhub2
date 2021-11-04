//--------------start---------------
<FrameLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:visibility="gone">
    <#if isGone1 == 1>
    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:layout_gravity="top"
            android:layout_marginStart="${marginTop}dp"
            android:orientation="horizontal"
            <#if isPadding == 1>
            android:paddingLeft="5dp"
            android:paddingTop="10dp"
            </#if>
            >

        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ellipsize="end"
                android:textColor="#${textColor}"
                android:textSize="12dp"
                android:textStyle="bold"></TextView>

        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textColor="#${textColor}"
                android:textSize="14dp"
                android:textStyle="bold"></TextView>
    </LinearLayout>
    </#if>
    <#if isGone2 == 1>
    <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="${marginTop}dp"
            android:layout_gravity="bottom">

        <ImageView
                android:layout_width="100dp"
                android:src="#${color}"
                android:layout_height="${height}dp">
        </ImageView>

        <#if isGone3 ==1>
        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="${hint}"
                android:textColor="#${color}"></TextView>
        </#if>
        <#if isGone4 ==1>
        <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="${text}"></Button>
        </#if>
    </RelativeLayout>
    </#if>
</FrameLayout>


//--------------end---------------
