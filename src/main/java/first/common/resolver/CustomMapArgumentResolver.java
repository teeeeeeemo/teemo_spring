package first.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import first.common.common.CommandMap;

public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	
	//supportsParameter : Resolver가 적용 가능한지 검사하는 역할.
	// 컨트롤러의 파라미터가 CommandMap 클래스인지 검사하도록 하였다.
	// 이를 위하여 Controller의 Map<String,Object> 형식을 CommandMap으로 변경함.
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}
	
	//resolveArgument : 파라미터와 기타 정보를 받아서 실제객체를 반환.
	//request에 담겨있는 모든 key, value를 commandMap에 저장하였다.
	//모든 파라미터가 담겨있는 commandMap을 반환. 
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		
		String key = null;
		String[] values = null;
		while(enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null) {
				commandMap.put(key, (values.length>1) ? values : values[0] );
			}
		}
		return commandMap;
	}

}
