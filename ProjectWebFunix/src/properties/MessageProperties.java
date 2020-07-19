/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [ConfigProperties.java], [Mar 21, 2020] [Kiều Văn Quang]
 */
package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import manager.common.Constant;

/**
 * Class Đọc các thông tin thiết định kết nối tới database
 * 
 * @author Kiều Văn Quang
 *
 */
public class MessageProperties {
	// lưu các cặp <key, value> trong file properties
	private static Map<String, String> mapDBProperties = new HashMap<String, String>();
	static {
		try {
			// tạo đối tượng kiểu Properties
			Properties properties = new Properties(); 
			// đọc file properties
			properties.load(new InputStreamReader(MessageProperties.class.getClassLoader()
					.getResourceAsStream(Constant.MESSAGE_PROPERTIES), "UTF-8"));
			// lưu các giá trị key trong file properties					
			Enumeration<?> enumeration = properties.propertyNames(); 
			// true nếu vẫn còn phần tử, false nếu tất cả phần tử đã được lấy ra
			while (enumeration.hasMoreElements()) { 
				// key = key tiếp theo
				String key = (String) enumeration.nextElement(); 
				// lấy value tương ứng với key
				String value = properties.getProperty(key); 
				// thêm vào list
				mapDBProperties.put(key, value); 
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * lấy value tương ứng với key trong file properties
	 * 
	 * @param key tên key trong file properties
	 * @return trả về value tương ứng với key
	 */
	public static String getValueByKey(String key) {
		String value = mapDBProperties.get(key);
		return value;
	}
}
