package json.node;

import java.io.IOException;
import java.io.File;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.io.FileUtils;
import json.ETJson;
import json.Config;
import config.bean.test.TestConfig;
import config.bean.test.TestType;
import config.bean.test.TestTypeConvert;
public class TestJson extends ETJson {

	@Override
	public void init() throws IOException {
		ConvertUtils.register(new TestTypeConvert(), TestType.class);
		String roleString = getConfig(Config.TEST_FILE, "Test.xlsx", TestConfig.class, "id");
		ConvertUtils.deregister(TestType.class);
		FileUtils.writeStringToFile(new File(Config.JSON_PAHT + "/Test.json"), roleString, "utf-8");
	}
}