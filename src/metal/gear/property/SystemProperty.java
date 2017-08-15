package metal.gear.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @desp
 *  
 * @package com.zillion.base.util
 * @author Johnathan
 * 
 * @sine 2014-3-25-下午05:21:15
 */
public class SystemProperty{
	
	private SystemProperty() { }
	/**
	 * 常驻内存的系统参 */
	private static final Logger Log = Logger.getLogger(SystemProperty.class);
	
	
	private static Map<String,String> propers = new HashMap<String,String>();
	/**
	 * 读取系统配置
	 */
	public static void init(){
		propers.putAll(readProperFile("system.properties"));
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getProper(String key){
		if(propers.size()==0){
			init();
		}
		return propers.get(key);
	}
	
	public static Map<String, String> getAllProper(){
		return propers;
	}
	/**
	 * 读取配置文件
	 * @param properFileName
	 * @return
	 */
	public static Map<String,String> readProperFile(String properFileName){
		Map<String,String> result = new HashMap<String,String>();
		Properties pero = new Properties();
		try {
			pero.load(new InputStreamReader(SystemProperty.class.getClassLoader().getResourceAsStream(properFileName), "UTF-8"));
		} catch (FileNotFoundException e) {
			Log.error("系统配置文件定位错误"+e.getMessage());
		} catch (IOException e) {
			Log.error("读取系统配置信息错误"+e.getMessage());
		}
		for(Object key : pero.keySet()){
			result.put(key.toString(), pero.get(key).toString());
		}
		return result;
	}
}
