# demos

自己学习过程中遇到需要研究测试的内容，或者是自己想要自己造轮子。将这部分代码内容收集到这个仓库。

## JDK

#### JUC练习

* cas
* volatile
* Reference （强、软、弱、虚）
* ThreadLocal
* BlockingQueue

#### jvm

* [打印一个对象在JVM中的存储大小](jdk/src/main/java/com/akikun/demo/obj/ObjectGraph.java)
* [safe-point](jdk/src/main/java/com/akikun/demo/jvm/SafePoint.java)

## 自己尝试造轮子

* [二级缓存保证数据一致性](custom/src/main/java/com/akikun/demo/custom/cache)
  
  *在集群多节点模式中，使用二级缓存，即存在本地缓存，如何保证本地缓存的数据准确？*
  
* [限流器](custom/src/main/java/com/akikun/demo/custom/limiter)
    - 滑动窗口
    - 漏桶
    - 令牌桶

