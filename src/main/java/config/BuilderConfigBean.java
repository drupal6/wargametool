package config;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;

import common.Pair;
import common.StringUtil;
import excel.OperatingExcel;

public class BuilderConfigBean {
	

	public static StringBuffer build(String excelName, String sheetName, String packetPath) {
		String configName = sheetName.substring(0, sheetName.length() - 5);
		OperatingExcel oe = new OperatingExcel();
		StringBuffer buffer = new StringBuffer();
		buffer.append("package "+packetPath.replace("/", ".") + "." + StringUtil.downCase(configName)+";\n\n");
//		buffer.append("##import##\n\n");
		buffer.append("public class "+StringUtil.firstUpCase(configName)+" {\n\n");
//		List<Pair<Integer, String>> fields = oe.readTitle(excelName, sheetName, 3);
		List<Pair<Integer, String>> fields = new ArrayList<Pair<Integer,String>>();
		fields.add(new Pair<Integer, String>(XSSFCell.CELL_TYPE_NUMERIC, "id"));
		fields.add(new Pair<Integer, String>(XSSFCell.CELL_TYPE_STRING, "test"));
		StringBuffer setgetBuff = new StringBuffer();
		for(Pair<Integer, String> pair : fields) {
			switch (pair.getLeft()) {
			case XSSFCell.CELL_TYPE_NUMERIC:
				buffer.append("\tprotected int " + pair.getRight()).append(";\n\n");
				buildSetGetMethod(setgetBuff, pair);
				break;
			case XSSFCell.CELL_TYPE_STRING:
				buffer.append("\tprotected String " + pair.getRight()).append(";\n\n");
				buildSetGetMethod(setgetBuff, pair);
				break;
			case XSSFCell.CELL_TYPE_FORMULA:
				buffer.append("\tprotected int " + pair.getRight()).append(";\n\n");
				buildSetGetMethod(setgetBuff, pair);
				break;
			default:
				break;
			}
		}
		buffer.append(setgetBuff);
		buffer.append("}");
		return buffer;
	}
	
	private static void buildSetGetMethod(StringBuffer setgetBuff, Pair<Integer, String> pair) {
		switch (pair.getLeft()) {
		case XSSFCell.CELL_TYPE_NUMERIC:
			setgetBuff.append("\tpublic int get" + StringUtil.firstUpCase(pair.getRight())).append("(){\n");
			setgetBuff.append("\t\t return " + pair.getRight()).append(";\n");
			setgetBuff.append("\t}\n\n");
			setgetBuff.append("\tpublic void set" + StringUtil.firstUpCase(pair.getRight())).append("(int "+pair.getRight()+"){\n");
			setgetBuff.append("\t\t this." + pair.getRight()).append("=" +pair.getRight() + ";\n");
			setgetBuff.append("\t}\n\n");
			break;
		case XSSFCell.CELL_TYPE_STRING:
			setgetBuff.append("\tpublic String get" + StringUtil.firstUpCase(pair.getRight())).append("(){\n");
			setgetBuff.append("\t\t return " + pair.getRight()).append(";\n");
			setgetBuff.append("\t}\n\n");
			setgetBuff.append("\tpublic void set" + StringUtil.firstUpCase(pair.getRight())).append("(String "+pair.getRight()+"){\n");
			setgetBuff.append("\t\t this." + pair.getRight()).append("=" +pair.getRight() + ";\n");
			setgetBuff.append("\t}\n\n");
			break;
		case XSSFCell.CELL_TYPE_FORMULA:
			setgetBuff.append("\tpublic int get" + StringUtil.firstUpCase(pair.getRight())).append("(){\n");
			setgetBuff.append("\t\t return " + pair.getRight()).append(";\n");
			setgetBuff.append("\t}\n\n");
			setgetBuff.append("\tpublic void set" + StringUtil.firstUpCase(pair.getRight())).append("(int "+pair.getRight()+"){\n");
			setgetBuff.append("\t\t this." + pair.getRight()).append("=" +pair.getRight() + ";\n");
			setgetBuff.append("\t}\n\n");
			break;
		default:
			break;
		}
	}
}
