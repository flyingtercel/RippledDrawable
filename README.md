# RippledDrawable
只支持5.0以上的手机，低版本的手机不能兼容。
rippleDrawable的要点解释
##### 一
```

rippleDrawable的mask颜色定义在ripple标签的color属性中；
```
##### 二
```
<1>无界的如下
<?xml version="1.0" encoding="utf-8"?>
<ripple
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="@color/colorAccent">
</ripple></br>
<2>只设置边界如下
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="@color/colorAccent">
    <item
        android:id="@android:id/mask"
        android:drawable="@color/colorPrimary" />
</ripple></br>
<3>设置边界，只能在图片区域中显示
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="@color/colorAccent">
    <item
        android:id="@android:id/mask"
        android:drawable="@mipmap/ic_launcher" />
</ripple></br>
  
<4> 设置边界，并在shape区域内显示
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <corners android:radius="100dp"/>
    <solid android:color="#ff0000"></solid>
</shape>
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="@color/colorAccent">
    <item
        android:id="@android:id/mask"
        android:drawable="@drawable/shape04" />
</ripple></br>
<4>显示在select标签之中
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
    android:color="@color/colorAccent">
    <item>
        <selector>
            <item android:drawable="@drawable/shape04" android:state_pressed="true"/>
            <item android:drawable="@mipmap/ic_launcher" android:state_pressed="false"/>
        </selector>
    </item>
</ripple></br>
rippleDrawable的mask大小定义在item标签中（除了selector有点特殊外，其余item的存在只是为了说明该mask的范围）：
1.如果 没有item标签，说明mask是无界限的；
2.如果item标签的drawable属性是一个颜色值（颜色值本身没有意义，什么颜色都没关系，它的存在只是为了说明：因为颜色只覆盖整个view，所以用颜色大小作为轮廓的
mask也只是覆盖整个view），说明mask的范围在使用这个rippleDrawable做背景的view的大小之内；
3.如果item标签的drawable属性是一个形状，那么形状的轮廓大小就是mask的范围；
4.如果item标签的drawable属性是一个selector，那么mask的大小还是selector的大小，而且不影响selector的本来的效果，就是说，mask效果和selector效果共存；
```
##### 三
```

rippleDrawable本身已经实现了将点击点作为涟漪起始中心的效果；
```
##### 四
```
在item中指明id属性为@android:id/mask 和 没有指明的区别在于：
前者让item的drawable属性只用于mask范围的界定，item的drawable属性不会直接出现在view背景中；
后者会直接在背景中出现，同时也用于mask范围的界定
```
