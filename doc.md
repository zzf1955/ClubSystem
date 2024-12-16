#

## intro

## tools

- getConnection(String username, String password)
- closeConnection(Connection conneciton)
- getUsername(Connection connection)

## table

### club

- function
    储存所有社团的名称与所属管理员

- key:
  - id 社团id，行号也行
  - name 社团名称
  - 管理员 社团管理员名称
  - 所属的管理员账号

### club_member（多张表）

- function
    储存各个社团的成员名称与职位

- key(each table):
  - club_name 此表对应的社团名称 同一张表中此 key 相同
  - member_name 社员名称
  - 社员职位 (社员 社团干事 管理员)

### club activity

- function
    用于储存社团发布的活动

- key
  - 发布的社团
  - 可编辑人员的username
  - 发布日期
  - 内容

### club notification

- function
    用于储存学校发布的社团公告

- key
  - 发布日期
  - 内容

## ui

### login frame

- function
    社团管理员登录

- 组件
  - username  text_field
  - password  text_field
  - login     button
    - 点击时 登录mysql
      - 成功进入 main_frame
      - 失败 弹窗登陆失败 (JDialog)

- 布局 gridbaglayout

```md
username: _____
password: _____
    login
```

### main frame

- layout borderLayout

- 组件
  - 左侧 panel 选择窗口
    - my club       button
    - club member   button
    - club activity button
    - notification  button
    - layout: 从上到下依次排列
  - 顶部 panel 菜单栏
    - edite button
    - find  button

### my club frame

- function
    管理某用户能管理的所有社团

    遍历club表，筛选出所有社团管理员账号 == 当前帐号 的数据条目并显示

- 组件

## structure

root/
    tools/
        tools.java
    ui/
        mainFrame.java
        loginFrame.java
    lib/
        mysql库
main.java

tools中出现异常向上抛出
