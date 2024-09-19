<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">모여모여</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" >
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <c:if test="${sessionScope.login.memId != null }">
                	<li class="nav-item"><a class="nav-link" style="color: white; " 
                		 href="${pageContext.request.contextPath}/galleryHome" >갤러리</a></li>
                	<li class="nav-item"><a class="nav-link" style="color: white; "
                		 href="#services">모임 일정</a></li>
                	<li class="nav-item"><a class="nav-link" style="color: white; "
                		 href="#services">추천 명소</a></li>
                	<li class="nav-item"><a class="nav-link" style="color: white; "
                		 href="#services">게시판</a></li>
                	<li class="nav-item dropdown">
                		<a class="nav-link dropdown-toggle" style="color: white; " href="${pageContext.request.contextPath}/"
                		role="button" data-bs-toggle="dropdown" aria-expanded="false">
                			${sessionScope.login.memName} 님</a>
                			<!-- dropdowm -->
							<ul id="dropdownMenu" class="dropdown-menu">
								<li><a class="dropdown-item" href="#">내정보</a></li>
								<li><hr class="dropdown-divider"></li>
								<c:if test="${sessionScope.gatheringMemList != null}">
									<c:forEach items="${sessionScope.gatheringMemList}" var="gMem" >
										<li>
											<form action="${pageContext.request.contextPath}/enterGathering" method="POST" >
												<input id="formCode" type="hidden" value='${gMem.gatherCode}' name="gatherCode" >
												<button id="formSubmitA" class="dropdown-item">${gMem.gatherName}</button>
											</form>
										</li>
									</c:forEach>
								</c:if>
							</ul>
                	</li>
                	<li class="nav-item"><a class="nav-link" style="color: white; " href="${pageContext.request.contextPath}/logOutDo">로그아웃</a></li>
                </c:if>
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
	
	// hover 시 글자색 변경
	for (let i of v_navLink){
		i.addEventListener('mouseover', () => {
			i.style.color = "#ffc800";
		});

		i.addEventListener('mouseout', () => {
			i.style.color = "#fff";
		});
	}
	
	//// 로그인 시 이름 드롭다운에 내정보 및 생성한 모임들 나열하기
	let v_formCode = document.getElementById("formCode");
	
	document.getElementById("formSubmitA").addEventListener("click", () => {
		v_formCode.submit();
	});
	
	
</script>
