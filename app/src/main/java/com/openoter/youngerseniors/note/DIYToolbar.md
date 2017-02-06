# 自定义Toolbar

## 1. 使用Toolbar

1.1 在标签中加入以下代码

```xml
<android.support.v7.widget.Toolbar
        android:minHeight="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:title="Title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        </android.support.v7.widget.Toolbar>
```

1.2 设置toolbar的样式(style.xml)

```xml
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <!--toolbar的背景颜色-->
        <item name="colorPrimary">@color/colorPrimary</item>
        <!--状态栏-->
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <!--EditText正在输入时，RadioButton的颜色-->
        <item name="colorAccent">@color/colorAccent</item>

        <item name="android:textColorPrimary">@color/toolbarColorWhite</item>
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>

        <item name="android:windowActionBar">false</item>
        <item name="android:windowNoTitle">true</item>

    </style>
```

1.3 给Toolbar中的元素进行事件监听

```java
    mToolBar.setNavigationOnClickListener();
```

1.4 使用menu（menu/...）

```java
    //把Menu与toolbar绑定
    mToolBar.inflateMenu(R.id.main_menu);
    mToolBar.setOnMenuItemClickListener();
```


## 2. 自定义ToolBar

2.1 一个toolbar的布局文件
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginRight="60dp"
        android:drawableLeft=""
        android:gravity="center"
        android:hint="关键字搜索" />

    <TextView
        android:id="@+id/tb_tv_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_gravity="center"
        android:gravity="center"
        android:textColor="@color/toolbarColorWhite"
        android:textSize="20sp" />

    <TextView
        android:id="@+id/tb_tv_right_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_gravity="center"
        android:gravity="center"
        android:textColor="@color/toolbarColorWhite"
        android:textSize="20sp" />

    <ImageButton
        android:id="@+id/tb_ib_right_btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        style="@android:style/Widget.Material.Toolbar.Button.Navigation"
        android:layout_centerVertical="true" />
</RelativeLayout>
```

