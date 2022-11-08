package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/**
 * @description: 设备信息  json格式
 * @author: zx
 * @date: 2022/11/08 10:31
 */
public class DeviceInfo extends JeepayObject {

    @ApiField("deviceType")
    private String deviceType; // 设备类型，智能POS：auto_pos，收银插件：cash_plugin
    @ApiField("deviceNo")
    private String deviceNo; // 设备号/激活码
    @ApiField("provider")
    private String provider; // 设备厂商

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}
