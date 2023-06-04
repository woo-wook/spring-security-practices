# spring-security-practices

## 오늘날의 보안

> 보안은 시스템의 개발에 관여하는 모든 사람들이 고려해야 한다. 비 기능적 특징이긴 하지만, 여러 영향을 끼칠 수 있다. DDos에 원치 않게 참여할 수 잇으며, 수익성에 중대한 영향을 끼칠 수도 있다.

### 스프링 시큐리티: 개념과 장점

> 스프링 시큐리티는 스프링 애플리케이션에 보안을 적용하는 과정을 간소화하는 프레임워크다. 스프링에서 보안을 구현할 때 가장 우선적인 선택이며, 인증, 권한 부여 및 일반적인 공격에 대한 방어를 구현하는 세부적인 맞춤 구성 방법을 제공한다.
> 스프링 시큐리티는 사실상 스프링의 표준이다. 맞춤 구성하는 방법을 알기만 하면 최고의 선택이 될 수 있다. 어노테이션, 빈 등을 능숙하게 사용하여 애플리케이션 수준의 보안을 정의한다. 가장 흔한 사례는 누가 리소스를 사용할 수 있는지 등을 구성한다. (일종의 로그인)
> 주요한 목적은 더 적은 코드로 원하는 기능을 구현하는 것이다. 

### 소프트웨어 보안

> 현재의 소프트웨어 시스템은 상당 부분이 민감한 정보일 수 있는 대량의 데이터를 관리한다. 애플리케이션은 이러한 정보의 접근, 변경 또는 가로챌 기회가 없어야한다. 이게 광범위한 보안의 의미다.
> 애플리케이션 보안은 실행되는 환경과 애플리케이션이 처리하고 저장하는 데이터를 보호하기 위해 해야 하는 모든 것을 나타낸다.

### 보안이 중요한 이유

> 애플리케이션은 모든 것을 원하는 접근 수준까지 보호해야 한다. 사람마다 느끼는 보안의 허들이 다르다. 보안에 주의를 기울이지 않으면 원치 않는 대가를 치러야 할 수 있다. 대부분은 시스템의 취약성을 악용할 수 있게 방치하는 것 보다 미리 보안에 투자하는 것이 훨씬 현명한 선택이다.

### 웹 애플리케이션의 일반적인 보안 취약성

> 일반적인 취약성으로 인증 취약성, 세션 고정, XSS, CSRF, 주입, 기밀 데이터 노출, 메서드 접근 제어 부족, 알려진 취약성이 있는 종속성 이용 등이 있다. 인증은 사용자의 ID를 확인하는 과정이고, 권한 부여는, 인증된 사용자가 특정 기능 혹은 데이터에 권리가 있는지 
> 확인하는 과정이다.

### OAuth 2 흐름 이해

> OAuth 2 프레임워크는 권한 부여 서버와 리소스 서버라는 두 가지 별도의 엔티티를 정의한다. 권한 부여 서버는 권한을 부여하고 사용자의 이용 권리 집합을 제공하는 토큰을 제공한다. 이 기능을 구현하는 벡엔드 부분을 **리소스 서버**라고 하면 호출할 수 있는 엔드포인트는 
> **보호된 리소스**로 볼 수 있다. 권한 부여를 수행한 후 획득한 토큰에 따라 리소스에 대한 호출이 허용되거나 거절된다. 토큰은 사무실 출입카드와 비슷하다. 방문자가 건물에 들어가면 카드를 먼저 받아야 한다. 출입 카드가 있으면 건물에 일부 지역에 접근할 수 있지만 모든 
> 문을 열 수 있는 것은 아니다. 액세스 토큰도 같은 맥락에서 작동한다. 토큰은 수명이 오래 유지되지 않으며, 만료되면 새로운 토큰을 받아야 한다.

## [스프링 시큐리티 - 첫번째 프로젝트](first-project)

> 스프링 부트는 스프링 프레임워크를 이용한 애플리케이션 개발에서 혁신적인 단계로 평가받는다. 미리 준비된 구성을 제공하므로 모든 구성을 작성하는 대신 자신의 구현과 일치하지 않는 구성만 재정의 하면 된다. 
> 이러한 접근 법을 **설정보다 관습**이라고 한다. 모놀리식으로 개발을 할 때에는 모든 구성을 정의하는데 큰 문제가 없었으나, 서비스 지향 아키텍처가 발전함에 따라서 고통스럽게 느껴지기 시작했다. 스프링 시큐리티 또한 기본 값을 제공한다.
> 이러한 기본 값을 알아보고, 인증의 개념을 살펴보자. 또한, spring-boot-starter-security가 어떻게 동작하는지 간단하게 알아보고. 종속성을 바탕으로 스트링 컨텍스트에 기본적인 구성을 어떻게 적용해주는지 알아보자.
> 간단하게 Rest API를 하나 만들어서 호출해보면 권한이 없음을 응답받을 수 있다. 스프링 시큐리티는 기본적으로 기본 사용자 이름(user)와 제공 된 암호 (실행 시 생성 된 암호)로 사용하여 인증해야 한다.
> 올바른 자격 증명을 보내면 응답의 본문이 정확하게 반환된다. 기본 프로젝트에는 주의할 별다를 보안 구성이 없다. 스프링 부트가 무엇을 구성하고, 구성의 재정의 하는 방법을 차례대로 알아보자.

### 기본 구성이란?

> 스프링 시큐리티는 인증 필터가 요청을 가로채 인증 관리자에게 위임하여 인증 공급자를 이용해 암호 등을 검증하여 보안 컨텍스트에 저장하여 인증을 수행한다. 
> 조금 더 자세히 설명하자면, 인증 필터는 인증 요청을 관리자에게 위임하오 응답을 바탕으로 보안 컨텍스트를 구현하며, 인증 관리자는 인증 공급자를 이용하여 인증을 처리한다. 
> 또한 인증 공급자는 인증 논리를 구현하고, 사용자 세부 정보 서비스를 사용하여 인증 논리에 이용한다. 인증 공급자는 암호 관리를 구현하는 암호 인코더를 인증 논리에 이용한다. 
> 보안 컨텍스트는 인증 프로세스 후 인증 데이터를 유지한다. 스프링 부트는 **UserDetailsService**와 **PasswordEncoder**를 자동으로 구성해준다. 
> 스프링이 구현한 자동 구현은 가본 자격 증명을 등록하는 일만 수행한다. 패스워드 인코더는 암호를 인코딩하여 기존과 일치하는지 확인하는 역할을 수행한다. 반드시 인증 흐름에 필요하다.
> **AuthenticationProvider**는 인증 논리를 정의하고 사용자와 암호의 관리를 위임한다. 이때 구현은 위에서 정의한 사용자 세부 서비스와 패스워드 인코더를 사용한다.

 