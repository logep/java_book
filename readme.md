# 基于Java的图书借阅管理系统设计与实现


### 功能介绍

平台采用B/S结构，后端采用主流的Springboot框架进行开发，前端采用主流的Vue.js进行开发。

整个平台包括前台和后台两个部分。

- 前台功能包括：首页、图书详情页、借阅中心、用户中心模块。
- 后台功能包括：总览、借阅管理、图书管理、分类管理、标签管理、评论管理、用户管理、运营管理、日志管理、系统信息模块。

### 适合人群

java初级学员、大学生、系统设计人员

### 演示地址

* 前台 http://1.117.171.66:8001/
* 后台 http://1.117.171.66:8001/#/admin

后台管理帐号：

用户名：admin123
密码：admin123

### 代码结构

- server目录是后端代码
- web目录是前端代码

### 部署运行

#### 后端运行步骤

(1) 下载代码后，使用IntelliJ IDEA打开server目录

(2) 配置application.yml文件，配置数据库和upload根目录

(3) 安装mysql 5.7数据库，并创建数据库，命名为java_book，创建SQL如下：
```
CREATE DATABASE IF NOT EXISTS java_book DEFAULT CHARSET utf8 COLLATE utf8_general_ci
```
(4) 恢复sql数据。在mysql下依次执行如下命令：

```
mysql> use java_book;
mysql> source D:/xxx/xxx/xxx.sql;
```

(5) 启动后端服务：点击IDEA顶部run按钮


#### 前端运行步骤

(1) 安装node 16.14

(2) cmd进入web目录下，安装依赖，执行:
```
npm install 
```
(3) 运行项目
```
npm run dev
```


### 界面预览

首页

 


后台页面

 



### 待完善功能

- 邮箱推送功能
- 手机号绑定功能
- 粉丝关注功能

### 问题咨询

微信：lengqin1024

