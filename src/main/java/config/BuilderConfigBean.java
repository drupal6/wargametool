package config;

import java.util.List;

import common.Pair;
import excel.OperatingExcel;

public class BuilderConfigBean {
	
	public static void main(String[] args) {
		build("D:/work/workspace/war.game.server/excel/test.xlsx", "test.xlsx");
	}

	public static void build(String excelName, String sheetName) {
		OperatingExcel oe = new OperatingExcel();
		
		List<Pair<Integer, String>> fields = oe.readTitle(excelName, sheetName, 3);
		for(Pair<Integer, String> pair : fields) {
			System.out.println("left:" + pair.getLeft() + " right:" + pair.getRight());
		}
	}
}
