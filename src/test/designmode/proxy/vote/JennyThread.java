package test.designmode.proxy.vote;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 用于异常的抛出而定义，因为Exception不能抛出，只有子类才能
 */
class MyException extends Exception {

    private static final long serialVersionUID = -1485825968429580934L;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }

    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}

/**
 * 一个小姨子需要的线程类
 */
class ShiMengRen implements Runnable {

    /**
     * 浏览量的链接
     */
    private String url = "http://www.wcpau.com/asp/VoteInfo.asp";

//    /**
//     * 点赞的链接
//     */
//    private String urlZan = "http://www.shimengren.com/article/yj/ups.jhtml";

    /**
     * 游记的ID
     */
    private String param = "CustomerID=361&Submit=投票VOTE";

    /**
     * 多线程共享的全局变量
     */
    // private volatile boolean flag = true;

    /**
     * 同时进入post提交的线程数
     */
    private static final int MAX_THREAD_COUNT = 25;

    /**
     * 同时进入post提交的线程数的计数器
     */
    private volatile static int threadNum = 0;

    /**
     * 计数
     */
    private static int num = 0;

    /**
     * 浏览次数
     */
    private static int view = 0;

    /**
     * 代理IP
     */
    private String[] proxyArray = { "127.0.0.1:8787", "115.239.210.199:80", "149.255.255.242:80",
            "124.172.242.175:80", "117.59.217.243:80", "183.234.59.89:18186", "117.59.217.236:80",
            "183.224.1.56:80", "120.202.249.230:80", "125.46.100.198:9999", "112.65.19.122:8080",
            "202.96.172.234:808", "183.224.1.114:80", "183.224.1.113:80", "222.66.115.229:80" };

    // public void setFlag(boolean flag) {
    // this.flag = flag;
    // }
    //
    // public boolean getFlag() {
    // return this.flag;
    // }
    //
    // public void stop() {
    // this.setFlag(false);
    // }
    //
    // public void start() {
    // this.setFlag(true);
    // }

    public void setNum(int num) {
        ShiMengRen.num = num;
    }

    public int getNum() {
        return ShiMengRen.num;
    }

    public void setThreadNum(int threadNum) {
        ShiMengRen.threadNum = threadNum;
    }

    public int getThreadNum() {
        return ShiMengRen.threadNum;
    }

    public int getView() {
        return ShiMengRen.view;
    }

    /**
     * @方法名：getProxy
     * @描述：随机获取代理IP
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:23:36
     * @return
     * @返回值：String[]
     * @异常说明：
     */
    public String[] getProxy() {
        String[] strlist = null;
        int len = proxyArray.length - 1;
        int num = 0;
        if (0 < len) {
            num = new Random().nextInt(len);
        }
        String proxy = this.proxyArray[num];
        if (proxy != "") {
            strlist = proxy.split(":");
        }

        return strlist;
    }

    /**
     * @方法名：sendGet
     * @描述：向指定URL发送GET方法的请求
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:26:27
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     * @返回值：String
     * @异常说明：
     */
    public String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;

        String[] proxyList = this.getProxy();
        if (null != proxyList) {
            System.setProperty("http.proxySet", "true");
            System.setProperty("http.proxyHost", proxyList[0]);
            System.setProperty("http.proxyPort", proxyList[1]);
        }
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result;
    }

    /**
     * @方法名：sendPost
     * @描述：向指定 URL 发送POST方法的请求
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:29:09
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     * @throws Exception
     * @返回值：String
     * @异常说明：
     */
    public String sendPost(String url, String param) throws Exception {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String[] proxyList = this.getProxy();
        if (null != proxyList) {
            System.setProperty("http.proxySet", "true");
            System.setProperty("http.proxyHost", proxyList[0]);
            System.setProperty("http.proxyPort", proxyList[1]);
        }
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw new MyException("发送 POST 请求出现异常！" + e);
            // System.out.println("发送 POST 请求出现异常！" + e);
            // e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                throw new MyException("发送 POST 请求出现异常！" + ex);
                // ex.printStackTrace();
            }
        }

        return result;
    }

    /**
     * @方法名：plusNum
     * @描述：总线程数的计数
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:29:53
     * @返回值：void
     * @异常说明：
     */
    public void plusNum() {
        ShiMengRen.num++;
    }

    /**
     * @方法名：reductionNum
     * @描述：总线程数的计数
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:03
     * @返回值：void
     * @异常说明：
     */
    public void reductionNum() {
        ShiMengRen.num--;
        ShiMengRen.num = ShiMengRen.num < 0 ? 0 : ShiMengRen.num;
    }

    /**
     * @方法名：plusThreadNum
     * @描述：并发线程数计数（其实也不算是并发），使用同步标识符，防止多线程的干扰
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:22
     * @返回值：void
     * @异常说明：
     */
    public synchronized void plusThreadNum() {
        ShiMengRen.threadNum++;
    }

    /**
     * @方法名：reductionThreadNum
     * @描述：并发线程数计数（其实也不算是并发），使用同步标识符，防止多线程的干扰
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:28
     * @返回值：void
     * @异常说明：
     */
    public synchronized void reductionThreadNum() {
        ShiMengRen.threadNum--;
        ShiMengRen.threadNum = ShiMengRen.threadNum < 0 ? 0 : ShiMengRen.threadNum;
    }

    /**
     * @方法名：plusView
     * @描述：浏览量计数，使用同步标识符，防止多线程的干扰
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:33
     * @返回值：void
     * @异常说明：
     */
    public synchronized void plusView() {
        ShiMengRen.view++;
    }

    /**
     * @方法名：runShiMengRen
     * @描述：调用sendPost的方法，以及各种计数
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:37
     * @throws MyException
     * @throws InterruptedException
     * @返回值：void
     * @异常说明：
     */
    public void runShiMengRen() throws MyException, InterruptedException {
        try {
               sendPost(this.url, this.param); // 刷点赞数
        } catch (Exception e) {
            Thread.sleep(2000);
            throw new MyException("网站出现异常，停止所有线程.");
        }

        finally {
            System.out.println("等待执行线程队列：" + this.getNum() + "，当前异步线程数量：" + this.getThreadNum()
                    + "，浏览次数：" + this.getView());
            this.reductionNum();
            this.reductionThreadNum();
        }
    }

    /**
     * @方法名：jennyLog
     * @描述：小姨子的日志记录，只为看浏览量的变化
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月18日 上午9:30:52
     * @param data
     * @throws IOException
     * @返回值：void
     * @异常说明：
     */
    public void jennyLog(String data) throws IOException {
        File file = new File("/home/beyond/tmp/Jenny.log.txt");
        // File file = new File("E:\\Jenny.log.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Writer out = new FileWriter(file);
        out.write(data);
        out.close();
    }

    /**
     * <p>
     * 主题：run
     * </p>
     * <p>
     * 描述：往死里拼命的Post提交数据
     * </p>
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (;;) {
            try {
                this.runShiMengRen();
            } catch (Exception e) {
                System.out.println("发送 POST 请求出现异常.");
                e.printStackTrace();
            }
        }
    }
}

/**
 * @类名：Jenny
 * @描述:小姨子类
 * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
 * @修改人：
 * @修改时间：2014年8月1日 下午5:53:48
 * @修改说明：<br/>
 * @版本信息：V1.0.0<br/>
 */
public class JennyThread {

    /**
     * @方法名：main
     * @描述：小姨子的主方法
     * @创建人：<a href=mailto: 529901956@qq.com>小姨子的姐夫</a>
     * @修改人：
     * @修改时间：2014年8月1日 下午5:53:48
     * @param args
     * @throws Exception
     * @返回值：void
     * @异常说明：
     */
    public static void main(String[] args) {
        Runnable t = new ShiMengRen();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "Thread-" + i).start();
        }
    }
}