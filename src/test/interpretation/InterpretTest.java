package test.interpretation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @描述：自定义注解
	
	1. @Documented —— 指明拥有这个注解的元素可以被javadoc此类的工具文档化。这种类型应该用于注解那些影响客户使用带注释的元素声明的类型。如果一种声明使用Documented进行注解，这种类型的注解被作为被标注的程序成员的公共API。
	
	2. @Target——指明该类型的注解可以注解的程序元素的范围。该元注解的取值可以为TYPE,METHOD,CONSTRUCTOR,FIELD等。如果Target元注解没有出现，那么定义的注解可以应用于程序的任何元素。
	
	3. @Inherited——指明该注解类型被自动继承。如果用户在当前类中查询这个元注解类型并且当前类的声明中不包含这个元注解类型，那么也将自动查询当前类的父类是否存在Inherited元注解，这个动作将被重复执行知道这个标注类型被找到，或者是查询到顶层的父类。
	
	4.@Retention——指明了该Annotation被保留的时间长短。RetentionPolicy取值为SOURCE,CLASS,RUNTIME。
 
 
 	ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
	ElementType.CONSTRUCTOR 可以给构造方法进行注解
	ElementType.FIELD 可以给属性进行注解
	ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
	ElementType.METHOD 可以给方法进行注解
	ElementType.PACKAGE 可以给一个包进行注解
	ElementType.PARAMETER 可以给一个方法内的参数进行注解
	ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月11日
 * @version v1.0.
 * 
 */
@Documented
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterpretTest {
	
	String comments() default "commentsTest";
	
	String value();
	
}
