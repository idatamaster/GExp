package aqpeq.utilities;

import java.util.HashSet;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class StringPoolUtility {

	private static BiMap<String, Integer> stringPool = HashBiMap.create();
	private static int autoIncrementId = 0;

	public static int insertIntoStringPool(String str) {

		if (stringPool.containsKey(str)) {
			return stringPool.get(str);
		}

		stringPool.put(str, ++autoIncrementId);

		return autoIncrementId;

	}

	public static int getIdOfStringFromPool(String str) throws Exception {

		if (stringPool.containsKey(str)) {
			return stringPool.get(str);
		}

		throw new Exception("no string  " + str + " exists in string pool");
	}

	public static boolean tokenExistsInPool(String str) throws Exception {

		return stringPool.containsKey(str);

	}

	public static String getStringOfId(int id) throws Exception {

		if (stringPool.inverse().containsKey(id)) {
			return stringPool.inverse().get(id);
		}

		throw new Exception("no such id " + id + " exists in string pool");
	}

	public static HashSet<String> getStringOfIds(HashSet<Integer> ids) throws Exception {

		HashSet<String> lbls = new HashSet<String>();

		for (int id : ids) {
			if (stringPool.inverse().containsKey(id)) {
				lbls.add(stringPool.inverse().get(id));
			}
		}

		return lbls;
	}

	public static int getCurrentAutoIncrement() {
		return autoIncrementId;
	}

}
