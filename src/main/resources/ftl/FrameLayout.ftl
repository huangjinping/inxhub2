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
                android:id="@+id/txt_${id5}"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ellipsize="end"
                android:textColor="#${textColor}"
                android:textSize="12dp"
                android:textStyle="bold"></TextView>

        <TextView
                android:id="@+id/txt_${id4}"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textColor="#${textColor}"
                android:textSize="14dp"
                android:textStyle="bold"></TextView>
    </LinearLayout>
    </#if>
    <#if isGone2 == 1>
    <RelativeLayout
            android:id="@+id/layout_${id1}"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="${marginTop}dp"
            android:layout_gravity="bottom">

        <ImageView
                android:id="@+id/img_${id1}"
                android:layout_width="100dp"
                android:src="#${color}"
                android:layout_height="${height}dp">
        </ImageView>

        <#if isGone3 ==1>
        <TextView
                android:id="@+id/txt_${id2}"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="${hint}"
                <#if isMargin ==1>
                android:layout_toLeftOf="@id/img_${id1}"
                android:layout_toRightOf="@id/img_${id1}"
                </#if>
                android:textColor="#${color}"></TextView>
        </#if>
        <#if isGone4 ==1>
        <Button
                android:id="@+id/btn_${id}_${id1}"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                <#if isPadding ==1>
                android:layout_above="@id/img_${id1}"
                android:layout_alignBottom="@id/img_${id1}"
                android:layout_toRightOf="@id/img_${id1}"
                </#if>
                android:text="${text}"></Button>
        </#if>
    </RelativeLayout>
    </#if>
</FrameLayout>


//--------------end---------------
