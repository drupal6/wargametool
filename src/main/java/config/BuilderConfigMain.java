package config;

import java.io.File;
import java.io.IOException;

import common.FileUtil;

public class BuilderConfigMain {
	
	private static final String excelName = "test.xlsx";
	private static final String beanPacketPath = "config/bean";
	private static final String providerPacketPath = "config/provider";
	private static final String excepPath = "D:/work/workspace/war.game.server/excel";
	private static final String basePath = "D:/work/workspace/war.game.server/src/main/java";
	
	public static void main(String[] args) throws IOException {
		String configName = excelName.substring(0, excelName.length() - 5);
		StringBuffer classbuffer = BuilderConfigBean.build(excepPath + File.separator + excelName, excelName, beanPacketPath);
		FileUtil.createClass(basePath, beanPacketPath, configName, classbuffer);
		StringBuffer providerbuffer = BuilderConfigProvider.creatConfigProvider(basePath, providerPacketPath, beanPacketPath, configName);
		FileUtil.createProvider(basePath, providerPacketPath, configName, providerbuffer);
	}

}
