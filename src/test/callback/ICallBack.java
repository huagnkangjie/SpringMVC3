package test.callback;


/**
 * 这是一个回调接口
 * @author Mr-H
 *
 */
public interface ICallBack {
	/** 
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数 
     * @param result 是答案 
     */  
    public void solve(String result); 
}
