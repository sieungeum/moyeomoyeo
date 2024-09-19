<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>모여모여 - 모두모두 모여랏</title>
        
        <!-- header -->
        <%@ include file="/WEB-INF/inc/header.jsp" %>
        
        <style type="text/css">
        	/* submit 시 button이 필요해서 추가 */
        	button{
        		border: 0px solid black;
        	}
        </style>

    </head>
    <body id="page-top">
        
        <!-- Navigation -->
        <%@ include file="/WEB-INF/inc/topNav.jsp" %>

        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">입장할 모임을 선택해주세요!</div>
            </div>
        </header>
        
        <!-- 가입된 모임들 보여주기 -->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div class="row">
                	<!-- 가입된 모임들 만큼 모임카드 생성 -->
                   	<c:forEach items="${sessionScope.gatheringMemList}" var="gMem">
	                   	<form action="${pageContext.request.contextPath}/enterGathering" method="POST"
	                   		class="col-lg-4 col-sm-6 mb-4">
	                        <!-- 가입된 모임 -->
	                        <div class="portfolio-item">
	                        	<!-- 이미지 클릭 시 해당 모임페이지로 이동(이미지는 모임의 대표이미지로 수정해야됨) -->
	                            <button class="portfolio-link" >
	                                <div class="portfolio-hover">
	                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
	                                </div>
	                                <img class="img-fluid" src="assets/img/portfolio/1.jpg" alt="..." />
	                            </button>
	                            
	                            <!-- 이미지 클릭 시 해당 모임의 코드명을 POST 형식으로 submit -->
	                            <div class="portfolio-caption">
	                           		<input class="gatheringCode" type="hidden" value="${gMem.gatherCode}" name="gatherCode">
	                                <div class="portfolio-caption-heading">${gMem.gatherName}</div>
	                                <div class="portfolio-caption-subheading text-muted">${gMem.gatherNick}</div>
	                            </div>
	                        </div>
		                </form>
                   	</c:forEach>
                </div>
            </div>
        </section>
        
        <!-- footer -->
        <%@ include file="/WEB-INF/inc/footer.jsp" %>
        
        <script type="text/javascript">
        	let v_gatheringCards = document.querySelectorAll(".portfolio-link");
        	let v_gatheringCodes = document.querySelectorAll(".gatheringCode");
        	
        	// 각 카드에 클릭이벤트 부여
        	for (let i = 0; i < v_gatheringCards.length; i++){
            	v_gatheringCards[i].addEventListener('click', () => {
        			// 클릭한 모임카드 submit
            		v_gatheringCards[i].submit();
        		});
        	}
        
        </script>

    </body>
</html>
