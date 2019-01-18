package kr.or.connect.guestbook.argumentresolver;

import java.util.*;

//맵을 직접 사용할수 없어서 필드로 하나 가지고 있고
//생성자와 세터 게터가 있음
public class HeaderInfo {
	private Map<String, String> map;

	public HeaderInfo() {
		map = new HashMap<>();
	}

	public void put(String name, String value) {
		map.put(name, value);
	}

	public String get(String name) {
		return map.get(name);
	}
}
