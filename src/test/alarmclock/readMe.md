
	仿小米闹钟实现设计：

	1、需用一个闹钟管理线程，检查是否有新的闹钟需要添加或者删除和更新
	     a)如果需要新增，则新增一个线程
		b)减少，则让对应的线程关闭
		c)暂停，则让线程等待
	2、多个闹钟同一个时间，提醒先后顺序规则
	3、智能获取该年法定工作日，自动跳过（网页抓取法定工作日或者配置设定）
	4、