//--------------start---------------
<RelativeLayout
        android:id="@+id/layout_${id}"
        android:layout_width="match_parent"
        android:visibility="gone"
        android:layout_height="wrap_content">

    <#if isGone1 == 1>
      <RelativeLayout
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_centerInParent="true">

        <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                <#if isPadding == 1>
                android:layout_margin="${margin}dp"
                </#if>
                <#if isMargin == 1>
                android:padding="${padding}dp"
                </#if>
                android:src="#${color}"></ImageView>
    </RelativeLayout>
    </#if>
    <#if isGone2 == 1>
    <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="5dp"
                <#if isGone1 == 1>
                android:layout_gravity="right"
                android:paddingLeft="10dp"
                </#if>
                android:text="12"
                android:textSize="14sp"></TextView>

        <TextView
                android:id="@+id/txt_${id}"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="left"
                android:layout_margin="5dp"
                android:paddingRight="10dp"
                android:text="12"
                android:textSize="14sp"></TextView>
    </FrameLayout>
    </#if>


    <#if isGone3 ==1>
    <ImageView
            android:id="@+id/img_${id}_${id1}"
            android:layout_width="match_parent"
            android:src="#${color}"
            <#if isPadding==1>
            android:padding="4dp"
            </#if>
            <#if isMargin==1>
            android:layout_margin="5dp"
            </#if>
            android:layout_height="1dp">
    </ImageView>
    </#if>

</RelativeLayout>
//--------------end---------------
