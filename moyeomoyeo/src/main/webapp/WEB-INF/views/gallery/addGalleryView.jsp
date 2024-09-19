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
			<div class="text-center">
				<h2 class="section-heading text-uppercase">갤러리 추가</h2>
			</div>
			
			<form id="contactForm" action="${pageContext.request.contextPath}/addGalleryDO" method="POST">
				<div class="row align-items-stretch mb-5">
					<div class="col-7 m-auto">
						<div class="form-group">
							<!-- 제목 input-->
							<label class="sjm-color-w mb-1" for="inputTitle">제목</label>
							<input class="form-control" id="inputTitle" type="text" name="gelTitle"/>
						</div>
						<div class="form-group">
							<!-- 설명 input-->
							<label class="sjm-color-w mb-1" for="inputContent">설명</label>
							<input class="form-control" id="inputContent" type="text" name="gelContent"/>
						</div>
						
						<!-- 파일 첨부 div 추가 -->
						
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
	
		
	
	</script>

</body>
</html>
