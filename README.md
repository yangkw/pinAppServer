# 拼车小程序
### 什么是拼车？

周末了，我要从学校出发去车站，打车需要40元，我想找一个和我一样要去车站的同学，这样只需要20元。

这，就是**拼车**。一起出行，AA付款。

区别于滴滴的拼车，全程对司机透明，可使乘客利益最大化。

### 使用技术

SpringBoot(SpringMVC+MyBatis)+Redis(GeoHash+缓存)+MySQL+WebSocket

分包结构

clinet:微信小程序端

server:Java服务端

sql:数据库文件

api：应用的入口，接口定义处

domain：业务实体类

infrastructure：基础设施层，与数据源的交互，以及配置文件定义处

service：业务主要逻辑
### 图例
#### 队伍聊天室列表
![example](https://tva1.sinaimg.cn/large/00831rSTly1gd47ostoszj30bz0khgne.jpg)

#### 队伍发布页列表
![example](https://tva1.sinaimg.cn/large/00831rSTly1gd47qexrenj30cq0m2q5r.jpg)


### 交流

**wechat**: kite_where

欢迎交流服务端开发相关技术，同时可长期帮忙内推阿里巴巴Java研发工程师岗，欢迎投递简历

下面是个人技术公众号，主攻源码，纯原创，低产用心

![WechatIMG2](http://ww2.sinaimg.cn/large/006tNc79ly1g55icd4zb7j308u0a9mxn.jpg)


