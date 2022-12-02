<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action=<c:url value = "/leadlecture/dshoidong/saveOrUpdate"/>
	method=POST>
	<div class="card-body">


		<div class="mb-3">
			<label for="id_hoidong" class="form-lablel">Mã Hội Đồng:</label> <input
				type="text" value="${lecture.idhoidong}" id="idhoidong" name="idhoidong"
				aria-describedby="id_hoidongid">
		</div>

		<button class="btn btn-primary" type="submit">
			<i class="fas fa-save"></i>
			<c:if test="${project.isEdit }">
				<span>Update</span>
			</c:if>

			<c:if test="${!project.isEdit }">
				<span>Save</span>
			</c:if>
		</button>
	</div>
</form>



