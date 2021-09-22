#1)基本指令
# 设置混淆的压缩比率 0 ~ 7
-optimizationpasses 5
# 混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames
# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共库的成员
-dontskipnonpubliclibraryclassmembers
# 混淆时不做预校验
-dontpreverify
# 混淆时不记录日志
-verbose
# 忽略警告
-ignorewarnings
# 代码优化
-dontshrink
# 不优化输入的类文件
-dontoptimize
# 保留注解不混淆
-keepattributes *Annotation*,InnerClasses
# 避免混淆泛型
-keepattributes Signature
# 保留代码行号，方便异常信息的追踪
-keepattributes SourceFile,LineNumberTable
# 混淆采用的算法
-optimizations !code/simplification/cast,!field/*,!class/merging/*

# dump.txt文件列出apk包内所有class的内部结构
-dump class_files.txt
# seeds.txt文件列出未混淆的类和成员
-printseeds seeds.txt
# usage.txt文件列出从apk中删除的代码
-printusage unused.txt
# mapping.txt文件列出混淆前后的映射
-printmapping mapping.txt


-keep public class * extends com.mvvm.net.beans.BaseResponse

#2）不需要混淆的android类
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService

-keep public class com.pateo.plugin.adapter.data.BaseConfig
-keep public class com.pateo.plugin.adapter.config.DefaultConfigAdapter

#3）support下的所有类及其内部类
-keep class android.support.** {*;}
-dontwarn android.support.**
-keep interface android.support.** { *; }


-keep class androidx.** {*;}
-keep interface androidx.** {*;}
-keep public class * extends androidx.**
-dontwarn androidx.**

#4）support v4/7库
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

#5）support design库
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

-keep class com.google.android.material.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**

#6）避免混淆自定义控件类的get/set方法和构造函数
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#7）关闭log日志
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}
#8）避免资源混淆
-keep class **.R$* {*;}

#9）避免layout中的onclick方法（android:onclick="onClick")混淆
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

#10)避免回调函数onXXEvent混淆
-keepclassmembers class * {
    void *(*Event);
}

#11）避免混淆枚举类
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#12）Native方法不混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#13）避免Parcelable混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#14)避免Serializable接口的子类中指定的某些成员变量和方法混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#15）webview混淆配置
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}
-keep public class * extends android.app.Activity
-keep public class [包名.类名]$[内部类]{
    public *;
}
-keepattributes JavascriptInterface

#16）ButterKnife混淆配置
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#17）okhttp3混淆配置
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
-keep public class TokenInterceptor


#18）Retrofit2混淆配置
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#19）Rxjava RxAndroid混淆配置
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#20）Glide混淆配置
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}



-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep public class * implements com.bumptech.glide.module.AppGlideModule
-keep public class * implements com.bumptech.glide.module.LibraryGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#21）Fastjson混淆配置
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.**{*; }

#22）Gson混淆配置
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }

#23）Banner混淆配置
-keep class com.youth.banner.** {
    *;
 }


 #24）百度定位混淆配置
 -keep class vi.com.gdi.** { *; }
 -keep public class com.baidu.** {*;}
 -keep public class com.mobclick.** {*;}
 -dontwarn com.baidu.mapapi.utils.*
 -dontwarn com.baidu.platform.comapi.b.*
 -dontwarn com.baidu.platform.comapi.map.*

 #百度导航混淆
 # BaiduNavi SDK
 -dontoptimize
 -ignorewarnings
 -keeppackagenames com.baidu.**
 -keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,LocalVariable*Table,*Annotation*,Synthetic,EnclosingMethod

 -dontwarn com.baidu.**
 -dontwarn com.baidu.navisdk.**
 -dontwarn com.baidu.navi.**

 -keep class com.baidu.** { *; }
 -keep interface com.baidu.** { *; }

 -keep class vi.com.gdi.** { *; }

 -dontwarn com.google.protobuf.**
 -keep class com.google.protobuf.** { *;}
 -keep interface com.google.protobuf.** { *;}

 -dontwarn com.google.android.support.v4.**
 -keep class com.google.android.support.v4.** { *; }
 -keep interface com.google.android.support.v4.app.** { *; }
 -keep public class * extends com.google.android.support.v4.**
 -keep public class * extends com.google.android.support.v4.app.Fragment

 #25）百度地图混淆配置
 -keep class com.baidu.** {*;}
 -keep class vi.com.** {*;}
 -dontwarn com.baidu.**
 -keep class com.baidu.location.** {*;}

 #26）高德地图混淆配置
 -dontwarn com.amap.api.**
 -dontwarn com.a.a.**
 -dontwarn com.autonavi.**
 -keep class com.amap.api.**  {*;}
 -keep class com.autonavi.**  {*;}
 -keep class com.a.a.**  {*;}

 #27）EventBus混淆配置
 -keepclassmembers class ** {
     public void onEvent*(***);
 }

 # Only required if you use AsyncExecutor
 -keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
     <init>(java.lang.Throwable);
 }
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

#ARouter混淆
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.core.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
-keep public class com.alibaba.android.arouter.base.**{*;}

-keep public class com.alibaba.android.arouter.**{*;}

# If you use the byType method to obtain Service, add the following rules to protect the interface:
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider

# If single-type injection is used, that is, no interface is defined to implement IProvider, the following rules need to be added to protect the implementation
# -keep class * implements com.alibaba.android.arouter.facade.template.IProvider

-keep class com.bytedance.bdtracker.**{ *; }
#-keep interface * implements androidx.lifecycle.Observer

-keep class com.airbnb.lottie.**{*;}
#-keep class com.airbnb.lottie.manager.FontAssetManager
-keep class com.alipay.sdk.**{*;}
-keep public class com.pateo.qingpay.**{*;}
-keep public class AbstractFlutterHostAdapter
-keep public class com.pateo.plugin.**{*;}
