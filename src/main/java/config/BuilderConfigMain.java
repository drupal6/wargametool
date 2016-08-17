package config;

import java.io.File;
import java.io.IOException;

import common.FileUtil;

public class BuilderConfigMain {
	
	private static final String excelName = "test.xlsx";
	private static final String packetPath = "config/bean";
	private static final String excepPath = "D:/work/workspace/war.game.server/excel";
	private static final String basePath = "D:/work/workspace/war.game.server/src/main/java";
	
	public static void main(String[] args) throws IOException {
		String configName = excelName.substring(0, excelName.length() - 5);
		StringBuffer buffer = BuilderConfigBean.build(excepPath + File.separator + excelName, excelName, packetPath);
		FileUtil.createClass(basePath, packetPath, configName, buffer);
	}

}
