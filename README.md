# DrawingBoardView

> 自定义画板，实现了一般画板了基础更能，有前进和撤销操作，可以修改画笔的颜色和粗细，有一键清除功能，并能将画面保存到本地。

![](https://ws1.sinaimg.cn/large/5cc1a78ely1fsq3ngaxjnj20cu0icmxx.jpg)
---
## 如何添加该开源库

---
### Gradle:
### Step 1. 添加JitPack仓库
在当前项目的根目录下的 build.gradle 文件中添加如下内容:
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
### Step 2. 添加项目依赖
```java
dependencies {
         implementation 'com.github.Lieeber:DrawingBoardView:v1.0'
}
```
---
## 个人博客
> www.lieeber.com
