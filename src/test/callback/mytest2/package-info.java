/**
 * https://www.cnblogs.com/xrq730/p/6424471.html
 * 
 * 这个帖子写很清楚
 * 
 * 
 * A a() -- > B b(), A 的a()调用 B的b(),等B的b()执行完毕后再调用A的c();
 *   c() <--    b()
 *   
 *   
 * 模拟的是这样一种场景：老师问学生问题，学生思考完毕回答老师。
 */
/**
 * @author huangkangjie
 *
 */
package test.callback.mytest2;