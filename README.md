Neon
====
  这是一个增值税发票系统，该系统主要以企业的进销项发票信息为基础，对企业的经营数据进行对比分析，根据分析结果出具分析报表，并且对企业的发票数据进行管 理，使得企业运营管理人员更为有效地，准确地调整经营策略。
  
***
#### 作者:Neon团队
#### 邮箱:13244237736@163.com
***

功能介绍
====
用户管理
----

* 用户登录，模拟公司分配给每个系统使用者一个账号，不同角色员工拥有不同的权限，进入页面不同。<br>
* 用户信息修改，用户可以通过该系统修改一些基本的信息，例如：用户名、密码、邮箱等基本信息。<br>
* 忘记密码，如果用户登录时忘记密码，可以点击忘记密码，系统随机生成一个安全性较高的新密码至用户邮箱。<br>
* 防止恶意登录，系统使用验证码的形式防止用户恶意登录。
    
分析模块
----

* ### 税收总额分析
   税收总额分析图通过折线图展示近十二个月和任意一年的进销项数据，通过柱状图来展示进销数据差值，用来分析公司的经营情况，并且可以设置进销项差值的合理范围，来改变差值柱状图的显示颜色，以此来提醒用户；除此之外，在图形的下方还计算出进销项的平均值和方差供用户进一步分析公司的经营情况。
   
* ### 产品税额分析
   产品税额分析图可以查看近十二个月或者任意某年的产品销项数据，每种产品用不同的颜色来区分，并且可以在图例上点击某一种产品隐藏它，使之能让有对比价值的产品放在一起进行对比分析，除此之外，用户还可以拖动查看范围滚动条，确定查看的销项税额范围之内的产品，使用户能更精确的定位到问题所在。
  
* ### 产品税额同比分析
   产品税额同比分析图可以查看各个产品上个月与去年同一个月的同比分析，可以使得用户能多角度的分析产品的销售情况，用户还可以通过图形上方的单选按钮来选择查看进项数据还是销项数据，除此之外，在季度的产品税额同比分析图中，还可以点击某一个季度，图形会进行下钻进一步分析这个季度里的每一个月的对比情况，使得用户更精准的查找到问题所在。
   
* ### 产品税额联动分析
  产品税额联动分析图可以查看上个任意一个月份的产品税额占比，与产品销项税额排名，当用户选择完月份或者季度或者年份后，这两个图是进行联动的，同时进行改变，使得用户可以通过不同的角度来进行分析公司的经营情况。除此之外，用户也可以通过点击图例，来隐藏某些产品，进一步确定分析的产品。
  
报表模块
----

* ### 明细报表
  用户可以通过查看明细报表来查看，每一张发票的具体细节，可以通过上方的搜索栏来搜索某一张发票的具体信息，并且可以删除、排序、更新，以及可以将报表下载成所需的excel表格。

* ### 同比报表
  用户可以通过同比报表查看每一年中每个月分的经营情况，由此可以来调整经营策略，同样该报表可以进行搜索、删除、更新、下载等功能。         

* ### 产品报表
  用户可以通过产品报表查看具体某种产品的销项情况，以此来更精细的分析公司经营情况，同样该报表具有搜索、删除、下载等功能。 

使用说明
====

>   1：用户需要将项目clone至本地电脑上。<br>
> 2：将resource目录下的Neon.war文件复制到本地tomcat容器的`webapps`目录中。<br>
>3：在本地达梦数据库中新建一个用户（用户名：`TEST`，密码：`123456789`），并且将`DBA角色`分发给用户TEST。<br>
>4：切换连接用户，使用`TEST用户`连接到数据库。<br>
>  5：在该用户下导入resource目录下NEON_DM文件中的数据库。<br>
>   6：`启动tomcat`，打开浏览器访问http://localhost:8080/Neon (如果tomcat端口修改，按照修改的端口访问)。<br>
    
演示地址
====

    [欢迎查看](http://47.94.220.5:8080/Neon)<br>


备注
====
* resource目录下的NEON_DM为备份数据库
* resource目录下的Video为项目视频介绍
* resource目录下的documents为项目文档
* resource目录下的Neon.war为项目的war包文件
