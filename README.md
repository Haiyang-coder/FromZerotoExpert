# FromZerotoExpert
the first item from shuaidi

1.遇到了第一个问题
        在学习Tomcat时, 部署服务时,想要loclhost后面不加8080的情况.原以为是应为Tomcat默认端口8080在调整至(进行端口转发设置)默认端口80就可以。
        　　注意:由于Mac是Unix,同Linux一样1024以下端口是没有监听权限的,当将Tomcat设置为默认80端口是无法响应的

        2 设置默认80端口

        mac下8080端口到80端口的转发
        MAC OS 本质上还是 Unix 系统, Unix 系统大多默认情况下非root用户是无法使用小于1024的常用端口的.这时候如果你开发中需要在普通用户下用到80端口, 比如 tomcat, 比如 vitualbox 下构建了一个 http 服务, 若你想直接通过 浏览器的 localhost 访问的话(不用加上莫名其妙的”:端口”的话)你就需要做一些系统端口转发的工作.

        1、创建文件 :

        sudo vim /etc/pf.anchors/eclipse.tomcat.forwarding

        文件内容 ：

        rdr pass on lo0 inet proto tcp from any to 127.0.0.1 port 80 -> 127.0.0.1 port 8080
        rdr pass on lo0 inet proto tcp from any to 127.0.0.1 port 443 -> 127.0.0.1 port 8443
        2、创建文件 :

        sudo vim /etc/pf-tomcat.conf
        文件内容 ：

        rdr-anchor “forwarding”
        load anchor “forwarding”from “/etc/pf.anchors/eclipse.tomcat.forwarding”
        3、启动
        sudo pfctl -ef /etc/pf-tomcat.conf
        执行结果
        root@ymdeMacBook-Air etc# sudo pfctl -ef /etc/pf-tomcat.conf
        pfctl: Use of -f option, could result in flushing of rules
        present in the main ruleset added by the system at startup.
        See /etc/pf.conf for further details.

        No ALTQ support in kernel
        ALTQ related functions disabled
        pf enabled　
        复制代码
        假设你的工程 http://localhost/myDemo.html 这时访问你的web工程, 你会发现 http://localhost/myDemo.html 这个不需要8080端口即可访问，加上 http://localhost:8080/myDemo.html 访问不了。

        4、关闭：
        sudo pfctl -d
        执行结果：
        root@ymdeMacBook-Air etc# sudo pfctl -d
        No ALTQ support in kernel
        ALTQ related functions disabled
        pf disabled
        这时你访问你的web工程, 你会发现 http://localhost/myDemo.html 这个访问不了，加上 http://localhost:8080/myDemo.html 即可访问。

        或者全部关闭
        pfctl -F all -f /etc/pf.conf

        然并卵 本人依然无法使用80端口 localhost显示 it works 是Apache服务器使用着

        输入以下代码 查看80端口的占用情况

        ~$ lsof -i:80

        关闭Apache
        ~$ sudo launchctl unload -w /System/Library/LaunchDaemons/org.apache.httpd.plist

        启动Apache
        ~$ sudo launchctl load -w /System/Library/LaunchDaemons/org.apache.httpd.plist
        关闭Apache之后,查看80端口 现在已经没有占用情况了
        重新设置80端口转发

        ~$ sudo pfctl -ef /etc/pf-tomcat.conf
        再去浏览器输入localhost看看
        成功了
