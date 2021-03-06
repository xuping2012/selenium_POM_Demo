package com.selenium.auto.pagafactory;

import org.openqa.selenium.WebDriver;

import com.selenium.auto.pagafactory.base.GetBrowerDriver;

/**
 * 
 * 基础页面，应该要封装一些基本操作
 * 
 * @author Joe-Tester
 *
 */
public class BasePage extends GetBrowerDriver {

	// 全局的webdirver
	protected static WebDriver driver = GetBrowerDriver.getWebDriver();
	
	// 超时时间，这个地方可以写入基类，作为全局变量
	protected static int TIMEOUT = 10;    
}
