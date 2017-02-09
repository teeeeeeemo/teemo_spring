## MAVEN의 **json view**주의 -> version 확인

## Log4j
- 최신 Log4j에서는 xml, json을 이용한 설정만 지원

## Interceptor 
- Handler Interceptor를 상속. 일단 현재 전처리기, 후처리기 구현.

## 요기서 잠깐 ! 
- 고대로 따라하다가 에러나서 개고생함. **version**에 따라서 지원유무 잘 확인하기
- 요번 프로젝트엔 깜빡하고 *target* 파일들 다 생성되었다. 나중에 만들땐 없애도록 !!!  
- 화나서그만둘뻔했다는사실 ㅎ ㅎ ㅎ ㅎ ㅎ ㅎ ㅎ 을 잊지말구 꼼꼼하게 살펴보기 -설정사항 ***.xml**
- 요기서 중요한거 : `*.xml , pom.xml은 내가 인터넷 다뒤져서 버전 맞춰준거. 절대 보존하기.`

# 170207 - 흔개(10)까지　完了 ! ! ! ㅠㅠ눈물날고같다 ... 

## HandlerMethodArgumentResolver 란?
- HandlerMethodArgumentResolver는 스프링 3.1부터 추가된 인터페이스 
- 스프링3.1 이전에는 WebArgumentResolver 라는 인터페이스 
- 스프링 사용시 **Controller**에 들어오는 Parameter를 수정하거나 공통적으로 추가해 주는 경우.
- 예를 들어, 로그인시 한 사용자의 아이디나 닉네임을 추가할 때 보통 세션에 담아놓고 사용하는데, 
- 여러번 사용되는 값을 일일이 세션에서 가져오는건 상당히 번거로운 일이당.
- HandlerMethodArgumentResolver는 사용자 요청이 **Controller**에 도달하기 전, 
- 그 요청의 파라미터들을 수정 수 있도록 해준다. 
- HandlerMethodArgumentResolver는 컨트롤러의 파라미터가 Map 형식이면 동작하지 않는다.
- 스프링에서 기본적으로 설정된 ArgumentResolver를 거치게 된다.
- 항상 위와같이 동작하는 것은 아니고 <mvc:annotation-driven/>을 선언하게 되면 위처럼동작. 

# 170207 - 흔개(11)까지 完了　！！！

- 파일업로드시에 잊지말아야할거 정리는 지금 못해 너무 피곤해 나중에 수정해 ... 

# 170209 - 흔개(13)까지 完了　！！！

