/*
 * 文 件 名:  EqptInfoBean.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Administrator
 * 修改时间:  2014年4月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package test.generic.test;

import java.io.Serializable;

/**
 * <设备实体类>
 * 
 * @author  Administrator
 * @version  [版本号, 2014年4月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class EqptBean implements Serializable,Comparable<EqptBean>
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 6633516797596353284L;
    
    // 路由器ID
    private int id;
    
    // Onenet设备ID
    private String onenetDevId;
    
    // 设备名称
    private String devName;
    
    // 设备版本信息
    private String devVersion;
    
    // 设备厂商
    private String devFac;
    
    // 设备类型
    private String devType;
    
    // 设备型号
    private String devModel;
    
    // 路由器SN
    private String sn;
    
    // 路由器的MAC地址
    private String mac;
    
    // 路由器接入密码
    private String connKey;
    
    // 设备激活状态，0：未激活；1：已初始化；2：已上报属性
    private String activeStatus;
    
    // 用户名
    private String userName;
    
    // 设备状态 0：在线，1：离线
    private String devStatus;
    
    //设备厂商id
    private String deviceprovider_id;
    
    //首次激活时间
    private Long firstActiveTime;
    
   //用户ID
    private String userId;
    
    //用户电话号码
    private String phoneNum;
    
    //设备所在区域
    private String devAreaCode;
    
    private String devAreaName;
    
    private String devID;
    
    //厂商详情
    private String facDesc;
    //设备类型详情
    private String modelDesc;
    
    
    /**
     * <默认构造函数>
     */
    public EqptBean()
    {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @return 返回 id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * @param 对id进行赋值
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * @return 返回 onenetDevId
     */
    public String getOnenetDevId()
    {
        return onenetDevId;
    }
    
    /**
     * @param 对onenetDevId进行赋值
     */
    public void setOnenetDevId(String onenetDevId)
    {
        this.onenetDevId = onenetDevId;
    }
    
    /**
     * @return 返回 devName
     */
    public String getDevName()
    {
        return devName;
    }
    
    /**
     * @param 对devName进行赋值
     */
    public void setDevName(String devName)
    {
        this.devName = devName;
    }
    
    /**
     * @return 返回 devVersion
     */
    public String getDevVersion()
    {
        return devVersion;
    }
    
    /**
     * @param 对devVersion进行赋值
     */
    public void setDevVersion(String devVersion)
    {
        this.devVersion = devVersion;
    }
    
    /**
     * @return 返回 devFac
     */
    public String getDevFac()
    {
        return devFac;
    }
    
    /**
     * @param 对devFac进行赋值
     */
    public void setDevFac(String devFac)
    {
        this.devFac = devFac;
    }
    
    /**
     * @return 返回 devType
     */
    public String getDevType()
    {
        return devType;
    }
    
    /**
     * @param 对devType进行赋值
     */
    public void setDevType(String devType)
    {
        this.devType = devType;
    }
    
    /**
     * @return 返回 devModel
     */
    public String getDevModel()
    {
        return devModel;
    }
    
    /**
     * @param 对devModel进行赋值
     */
    public void setDevModel(String devModel)
    {
        this.devModel = devModel;
    }
    
    
    /**
     * @return 返回 connKey
     */
    public String getConnKey()
    {
        return connKey;
    }
    
    /**
     * @param 对connKey进行赋值
     */
    public void setConnKey(String connKey)
    {
        this.connKey = connKey;
    }
    
    /**
     * @return 返回 activeStatus
     */
    public String getActiveStatus()
    {
        return activeStatus;
    }
    
    /**
     * @param 对activeStatus进行赋值
     */
    public void setActiveStatus(String activeStatus)
    {
        this.activeStatus = activeStatus;
    }
    
    /**
     * @return 返回 userName
     */
    public String getUserName()
    {
        return userName;
    }
    
    /**
     * @param 对userName进行赋值
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    /**
     * @return 返回 devStatus
     */
    public String getDevStatus()
    {
        return devStatus;
    }
    
    /**
     * @param 对devStatus进行赋值
     */
    public void setDevStatus(String devStatus)
    {
        this.devStatus = devStatus;
    }
    
    /**
     * @return 返回 deviceprovider_id
     */
    public String getDeviceprovider_id()
    {
        return deviceprovider_id;
    }
    
    /**
     * @param 对deviceprovider_id进行赋值
     */
    public void setDeviceprovider_id(String deviceprovider_id)
    {
        this.deviceprovider_id = deviceprovider_id;
    }
  
    
    public Long getFirstActiveTime()
    {
        return firstActiveTime;
    }

    
    public void setFirstActiveTime(Long firstActiveTime)
    {
        this.firstActiveTime = firstActiveTime;
    }

    
    @Override
	public String toString() {
		return "EqptBean [onenetDevId=" + onenetDevId + ", sn=" + sn + ", mac=" + mac + "]";
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
     * @param o
     * @return
     */
    @Override
    public int compareTo(EqptBean o)
    {
    	if(this.id>o.id)
    	{
    		return 1;
    	}
    	else if(this.id<o.id)
    	{
    		return -1;
    	}
    	else
    	{
    		return 0;
    	}    	
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDevAreaCode() {
		return devAreaCode;
	}

	public void setDevAreaCode(String devAreaCode) {
		this.devAreaCode = devAreaCode;
	}

	public String getDevAreaName() {
		return devAreaName;
	}

	public void setDevAreaName(String devAreaName) {
		this.devAreaName = devAreaName;
	}

	public String getDevID() {
		return devID;
	}

	public void setDevID(String devID) {
		this.devID = devID;
	}

	public String getFacDesc() {
		return facDesc;
	}

	public void setFacDesc(String facDesc) {
		this.facDesc = facDesc;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}
    
}
