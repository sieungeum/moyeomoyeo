<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>회원가입</title>

	<!-- header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>

</head>
<body id="page-top">

	<!-- Navigation -->
	<%@ include file="/WEB-INF/inc/topNav.jsp"%>

	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
		
			<!-- Masthead -->
			<div class="text-center">
				<h2 class="section-heading text-uppercase">회원가입</h2>
				<h3 class="section-subheading text-muted">환영합니다! 여러분의 청춘을 응원합니다!</h3>
			</div>
			
			<!-- 회원가입 정보 입력 -->
			<form id="contactForm" action="${pageContext.request.contextPath}/signUpDo" method="POST">
				<div class="row align-items-stretch mb-5">
					<div class="col-7 m-auto">
						<!-- 아이디 input-->
						<div class="form-group">
							<label class="sjm-color-w mb-1" for="inputID">아이디</label>
							<input class="form-control" id="inputName" type="text" name="memId" />
						</div>
						
						<!-- 비번 input-->
						<div class="form-group">
							<label class="sjm-color-w mb-1" for="inputPw">비밀번호</label>
							<input class="form-control" id="inputPw" type="password" name="memPw"/>
						</div>
						
						<!-- 닉네임 input-->
						<div class="form-group">
							<label class="sjm-color-w mb-1" for="input">이름</label>
							<input class="form-control" id="inputEmail" type="text" name="memName" />
						</div>
						
						<!-- 이메일 input-->
						<div class="form-group">
							<label class="sjm-color-w mb-1" for="inputEmail">이메일</label>
							<input class="form-control" id="inputEmail" type="email"  name="memEmail" />
						</div>
					</div>
				</div>
				
				<!-- Submit Button -->
				<div class="text-center">
					<button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">회원가입</button>
				</div>
				
			</form>
		</div>
	</section>

	<!-- footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>
</html>
