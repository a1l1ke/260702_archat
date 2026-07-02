<%-- WEB-INF/views/chat.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>AI 챗봇</title>
</head>
<body>
    <form action="<c:url value="/chat"/>" method="post">
        <input name="message" placeholder="메시지를 입력하세요" />
        <select name="model">
            <option value="gemma-4-26b-a4b-it">빠르지만 약간 멍청</option>
            <option value="gemma-4-31b-it">안 빠르지만 덜 멍청</option>
            <option value="gemini-3.1-flash-lite">빠른데 덜 멍청</option>
        </select>
        <button>전송</button>
    </form>
    <section>
        <c:if test="${empty chats}">
            <p>아직 채팅이 없습니다</p>
        </c:if>
        <c:forEach var="chat" items="${chats}">
            <div>
                <ul>
                    <li><strong>${chat.owner}</strong></li>
                    <li>모델 : ${chat.model}</li>
                    <li>${chat.message}</li>
                    <li>작성일시 : ${chat.timestamp}</li>
                </ul>
            </div>
        </c:forEach>
    </section>
</body>
</html>
