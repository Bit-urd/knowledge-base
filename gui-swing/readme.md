1. 初始化数据库、表
- te_user是用户表
- te_disk是CD表
- tr_user_disk是user\disk关系表
- opera_log是操作日志表，记录CD的借还日志

2. 创建一个三个参数的存储过程
3. 创建一个te_disk上的触发器
 CD的num发生变化时会记录日志，用来判断CD的卖的好坏
4. 主程序入口，启动程序