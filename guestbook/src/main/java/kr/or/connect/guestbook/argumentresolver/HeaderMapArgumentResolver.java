package kr.or.connect.guestbook.argumentresolver;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

//두가지 메서드를 가지고 있음
public class HeaderMapArgumentResolver
		implements org.springframework.web.method.support.HandlerMethodArgumentResolver {
	
	//컨트롤러가 4가지이면 4번 호출되는 메소드
	//인자의 정보를 파라미터로 전달
	//해당 파라미터에 원하는 정보있으면 true / 없으면 false
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType() == HeaderInfo.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		//헤더인포객체에 전달
		HeaderInfo headerInfo = new HeaderInfo();
		
		//Iterator로 받아와서 값을 꺼내고, headerInfo에 넣는 작업
		Iterator<String> headerNames = webRequest.getHeaderNames();
		while(headerNames.hasNext()) {
			String headerName = headerNames.next();
			String headerValue = webRequest.getHeader(headerName);
			System.out.println(headerName + " , " + headerValue);
			headerInfo.put(headerName, headerValue);
		}
		
		return headerInfo;
	}

}
