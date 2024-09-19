<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
    	<!-- logo, 클릭 시 home 으로 이동 -->
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">모여모여</a>
        
        <!-- 화면 크기가 일정 길이만큼 줄어들면 메뉴바 생성 -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" >
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        
        <!-- Navigation menu -->
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
            	<!-- 로그인 되어있는 경우 -->
                <c:if test="${sessionScope.login.memId != null }">
                
                	<!-- dropdowm -->
                	<li class="nav-item dropdown">
                		<!-- 로그인 된 닉네임 출력 -->
                		<a class="nav-link dropdown-toggle" style="color: white; " href="${pageContext.request.contextPath}/"
                		role="button" data-bs-toggle="dropdown" aria-expanded="false">${sessionScope.login.memName} 님</a>
                			
                			<!-- dropdown 시 나오는 내용들 -->
							<ul id="dropdownMenu" class="dropdown-menu">
								<li><a class="dropdown-item" href="#">내정보</a></li>
								
								<li><hr class="dropdown-divider"></li> <!-- 구분용 선 -->
								
								<!-- 가입된 모임이 있을 경우 -->
								<c:if test="${sessionScope.gatheringMemList != null}">
									<!-- dropdowm에서 가입된 모임 클릭 시 그 모임의 GatherinHome으로 이동 -->
									<c:forEach items="${sessionScope.gatheringMemList}" var="gMem" >
										<li>
											<form action="${pageContext.request.contextPath}/enterGathering" method="POST" >
												<!-- 사용자에게 숨길 모임 코드명 -->
												<input id="formCode" type="hidden" value='${gMem.gatherCode}' name="gatherCode" >
												
												<button id="formSubmitA" class="dropdown-item">${gMem.gatherName}</button>
											</form>
										</li>
									</c:forEach>
								</c:if>
							</ul>
                	</li>
                	
                	<!-- 로그아웃 -->
                	<li class="nav-item"><a class="nav-link" style="color: white; " href="${pageContext.request.contextPath}/logOutDo">로그아웃</a></li>
                	
                </c:if>
                
                <!-- 비로그인 시 -->
                <c:if test="${sessionScope.login.memId == null }">
                	<li class="nav-item"><a class="nav-link" style="color: white; " href="#services">가이드</a></li>
	                <li class="nav-item"><a class="nav-link" style="color: white; " href="${pageContext.request.contextPath}/signInView">로그인</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>


<!-- 매우 화나서 만든 특정 영역 진입 시 네비게이션 메뉴 색 변경 막는 javascript -->
<script>
	let v_navLink = document.querySelectorAll(".nav-link");
	
	// hover 시 글자색 변경(이거 안하면 지정 css 코드에 먹힘)
	for (let i of v_navLink){
		// 마우스를 갔다 뎃을 때
		i.addEventListener('mouseover', () => {
			i.style.color = "#ffc800";
		});

		// 마우스를 땟을 때
		i.addEventListener('mouseout', () => {
			i.style.color = "#fff";
		});
	}
	
</script>
