<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<div>
	<h6 class="c-c-content c-infor-title" id="i-art-comment">
		<span class="commentTitle">评论</span>
	</h6>
	<section class="lh-bj-list pr mt20 replyhtml">
		<ul>
			<li class="unBr">
				<aside class="noter-pic">
					<c:if test="${empty user.pic_img }">
						<img width="50" height="50" class="pic_img" src="/static/inxweb/img/avatar-boy.gif">
					</c:if>
					<c:if test="${!empty user.pic_img }">
						<img width="50" height="50" class="pic_img" src="<%=staticImage%>${user.pic_img }">
					</c:if>
				</aside>
				<div class="of">
					<section class="n-reply-wrap">
						<fieldset>
							<textarea name="" placeholder="输入您要评论的文字" id="commentContent"></textarea>
						</fieldset>
						<p class="of mt5 tar pl10 pr10">
							<span class="fl "><tt class="c-red commentContentmeg" style="display: none;"></tt></span>
							<a href="javascript:addComment();" title="回复" class="lh-reply-btn">回复</a>
						</p>
					</section>
				</div>
			</li>
		</ul>
	</section>
	<c:if test="${empty commentList }">
		<!-- /无数据提示 开始-->
		<section class="no-data-wrap">
			<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">还没有评论，快来抢沙发吧...</span>
		</section>
		<!-- /无数据提示 结束-->
	</c:if>
	<c:if test="${!empty commentList }">
		<section class="">
			<section class="question-list lh-bj-list pr">
				<ul class="pr10">
					<c:forEach items="${commentList }" var="ac">
						<li>
							<aside class="noter-pic">
								<c:if test="${empty ac.pic_img }">
									<img width="50" height="50" class="pic_img" src="/static/inxweb/img/avatar-boy.gif">
								</c:if>
								<c:if test="${!empty ac.pic_img }">
									<img width="50" height="50" class="pic_img" src="<%=staticImage%>${ac.pic_img }">
								</c:if>
							</aside>
							<div class="of">
								<span class="fl"> 
								<font class="fsize12 c-blue"> 
									<c:if test="${empty ac.user_name }">
										${ac.email}
									</c:if>
									<c:if test="${!empty ac.user_name }">
										${ac.user_name}
									</c:if>
								</font>
								<font class="fsize12 c-999 ml5">评论：</font></span>
							</div>
							<div class="noter-txt mt5">
								<p><c:out value="${ac.content}"></c:out></p>
							</div>
							<div class="of mt5">
								<span class="fr"><font class="fsize12 c-999 ml5"><fmt:formatDate value="${ac.addtime}" pattern="yyyy/MM/dd HH:mm" /></font></span> <span class="fl"> <a class="noter-dy vam" title="回复" href="javascript: void(0)" onclick="queryCommentReply('${ac.comment_id}')">
										<em class="icon18">&nbsp;</em>(<span class="replyCount${ac.comment_id}">${ac.reply_count}</span>)
									</a> <tt title="赞一下" class="noter-zan vam ml10" onclick="addPraise('${ac.comment_id}',4)">
										<em class="icon18">&nbsp;</em>(<span class="addPraise${ac.comment_id}_4 praiseCount">${ac.praise_count }</span>)
									</tt>
								</span>
							</div>
							
							<div class="n-reply">
								<section class="n-reply-wrap">
									 <c:forEach items="${ac.son}" var="son">
									<li>
							<aside class="noter-pic">
								<c:if test="${empty son.pic_img }">
									<img width="50" height="50" class="pic_img" src="/static/inxweb/img/avatar-boy.gif">
								</c:if>
								<c:if test="${!empty son.pic_img }">
									<img width="50" height="50" class="pic_img" src="<%=staticImage%>${ac.pic_img }">
								</c:if>
							</aside>
							<div class="of">
								<span class="fl"> 
								<font class="fsize12 c-blue"> 
									<c:if test="${empty son.user_name }">
										${ac.email}
									</c:if>
									<c:if test="${!empty son.user_name }">
										${ac.user_name}
									</c:if>
								</font>
								<font class="fsize12 c-999 ml5">评论：</font></span>
							</div>
							<div class="noter-txt mt5">
								<p><c:out value="${son.content}"></c:out></p>
							</div>
							<div class="of mt5">
								<span class="fr"><font class="fsize12 c-999 ml5"><fmt:formatDate value="${ac.addtime}" pattern="yyyy/MM/dd HH:mm" /></font></span> <span class="fl"> <a class="noter-dy vam" title="回复" href="javascript: void(0)" onclick="queryCommentReply('${ac.comment_id}')">
										<em class="icon18">&nbsp;</em>(<span class="replyCount${ac.comment_id}">${ac.reply_count}</span>)
									</a> <tt title="赞一下" class="noter-zan vam ml10" onclick="addPraise('${ac.comment_id}',4)">
										<em class="icon18">&nbsp;</em>(<span class="addPraise${ac.comment_id}_4 praiseCount">${ac.praise_count }</span>)
									</tt>
								</span>
							</div>
									 </c:forEach>
									<fieldset>
										<textarea name=""  class="commentReplyMsgContent${ac.comment_id}">
										</textarea>
									</fieldset>
									<p class="of mt5 tar pl10 pr10">
										<span class="fl"><tt class="c-red commentReplyMsg${ac.comment_id}"></tt></span>
										<a onclick="addCommentReply('${ac.comment_id}')" class="lh-reply-btn" title="回复" href="javascript: void(0)"></a>
									</p>
								</section>
								<div class="mt10 pl10 pr10 pb10 commentReply${ac.comment_id}"></div>
							</div> <!-- /回复盒子 -->
						</li>
					</c:forEach>
				</ul>
			</section>
		</section>
	</c:if>
	<!-- 公共分页 开始 -->
	<jsp:include page="/WEB-INF/jsp/common/ajaxpage.jsp"></jsp:include>
	<!-- 公共分页 结束 -->
</div>
<script>
	$(function() {
		dialog('提示信息', "成功", 0);
		replyFun(); //回复展开
	});
// 	var totalResultSize = ${page.totalResultSize};
// 	$(".totalResultComment").html(totalResultSize);
// 	var order = "${comment.order}";
// 	var title = "评论";
// 	if (type == 1) {
// 		title = "文章评论（${page.totalPageSize}条）"
// 	}
// 	if (type == 2) {
// 		title = "课程评论"
// 		if(order=='praiseCount'){
// 			title = "精彩评论"
// 			$(".replyhtml").hide();
// 		}
		
// 	}
	
	$(".commentTitle").html(title);
</script>