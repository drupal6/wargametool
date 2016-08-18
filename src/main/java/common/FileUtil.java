package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	
	public static void createClass(String basePath, String packetPath, String configName
			, StringBuffer buffer) throws IOException {
		if(buffer == null) {
			return;
		}
		creatPacket(basePath + File.separator +  packetPath, StringUtil.downCase(configName));
		File classFile = new File(basePath + File.separator + packetPath+ File.separator + StringUtil.downCase(configName)
			, StringUtil.firstUpCase(configName)+"Config.java");
		if(classFile.exists()) {
			classFile.delete();
		}
		classFile.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(classFile));
	    output.write(buffer.toString());
	    output.close();
	    System.out.println(basePath + File.separator + packetPath + File.separator + StringUtil.downCase(configName) 
	    	+ File.separator + StringUtil.firstUpCase(configName) +"Config class is created!");
	}
	public static void createProvider(String basePath, String packetPath, String configName
			, StringBuffer buffer) throws IOException {
		if(buffer == null) {
			return;
		}
		File providerFile = new File(basePath + File.separator + packetPath
		, StringUtil.firstUpCase(configName)+"Provider.java");
		if(providerFile.exists()) {
			providerFile.delete();
		}
		providerFile.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(providerFile));
		output.write(buffer.toString());
		output.close();
		System.out.println(basePath + File.separator + packetPath + File.separator + StringUtil.downCase(configName) 
		+ File.separator + StringUtil.firstUpCase(configName) +"Porvider class is created!");
	}
	
	/**
	 * 创建packet
	 * @param basePath
	 * @param packetName
	 */
	public static void creatPacket(String path, String packetName) {
		File packet = new File(path, packetName);
		if(false == packet.exists()) {
			packet.mkdir();
			System.out.println(path  + File.separator + StringUtil.firstUpCase(packetName) +" packet is created!");
		}
	}

	
}
