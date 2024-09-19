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
<title>모임 만들기</title>

<!-- header -->
<%@ include file="/WEB-INF/inc/header.jsp"%>

</head>
<body id="page-top">

	<!-- Navigation -->
	<%@ include file="/WEB-INF/inc/topNavG.jsp"%>

	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
		
			<!-- Masthead -->
			<div class="text-center">
				<h2 class="section-heading text-uppercase">모임 이름을 지어주세요</h2>
				<h3 class="section-subheading text-muted">센스있는 모임 이름을 지어봐요!</h3>
			</div>
			
			<!-- 모임 생성 -->
			<form id="contactForm" action="${pageContext.request.contextPath}/makeGatheringDo" method="POST">
				<div class="row align-items-stretch mb-5">
					<div class="col-7 m-auto">
					
						<!-- 모임명 input-->
						<div class="form-group">
							<input class="form-control" id="inputGName" type="text" name="gatherName" />
						</div>
						
						<!-- 닉네임 input-->
						<div class="form-group">
							<label class="sjm-color-w mb-1" for="inputPw">모임 내 닉네임 설정</label>
							<input class="form-control" id="inputGNick" type="text" name="gatherNick"/>
						</div>
					</div>
				</div>
				
				<!-- Submit Button -->
				<div class="text-center">
					<button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">생성</button>
				</div>
			</form>
			
		</div>
	</section>

	<!-- footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
	<script type="text/javascript">
	
		const v_submitButton = document.getElementById("submitButton");
		
		// 모임 생성 시 알람 출력 후 submit
		document.getElementById("submitButton").addEventListener("click", () => {
			alert("모임이 생성되었어요! 좋은 추억 많이 쌓으세요!");
			v_submitButton.submit();
		});
		
	</script>

</body>
</html>
