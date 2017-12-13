back 是一个 Maven 的 pom 工程，是用来聚合 controller，pojo，pojo，server 子工程的

分布式 SSM 框架的整合：
1. Dao层整合：
    使用 mybatis 框架。 mybatis的配置文件：mybatis.xml
        mybatis.xml 需要配置：1.别名  2.插件
    Spring使用的配置文件： ApplicationContext.xml
        ApplicationContext.xml 需要配置：
            1. 配置数据源。
            2. 配置 sqlsessionfactory
            3. mapper 代理对象配置到 Spring 容器里

2. Service 层整合：
    1. 配置事务管理(放到了 ApplicationContext-mybatis.xml 里)
    2. 把 service 实现类对象放到 Spring 容器里

3. web 层整合：
    1. 注解驱动
    2. 三大主键： 视图解析器，适配器，
    3. 扫描 controller 组件

4. web.xml 配置：
    1. Spring 容器配置
    2. SpringMVC 前端控制器(servlet)
    3. post 乱码处理