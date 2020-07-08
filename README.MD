## 目的
- 示例分层结构
- 示例如何使用 data-jdbc 实现 repository 


## 核心要点
- 持久层使用 data-jdbc 
- 


## 导读
- account 
  - 一个简单实体，来表现 CrudRepository 的简便之处
  - @Query 自定义查询
  - @Modifying + @Query 更新语句 
- product, 使用底层接口
  - 在主键有值时如何 insert 
- legoset
   1. 关联关系， one2one 和 one2many
   2. 怎么处理非持久化字段
   3. 决定持久化访问  属性 还是 字段
   4. 通过提供响应的构造方法或 with 方法让持久化设置应用不能设置的字段 
   5. 自定义转化器
   6. 实体事件
   7. 查询结果转化成自定义类型
- common 公共包
  - 公共的保存实体的方法 insert 
  - 统一的应答类型
  - 统一的 Controller 异常处理 
   