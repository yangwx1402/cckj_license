cckj_license
============

一个可以生成和验证license的java项目

初次运行可参看com.cckj.license.v1.example包里的例子,该例子是制作一个可以验证主机mac地址的license


如果需要修改自己的验证机制,可以继承BaseLicenseManager并复写里面的validate方法即可实现.