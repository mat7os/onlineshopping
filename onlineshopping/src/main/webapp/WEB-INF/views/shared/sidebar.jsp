<h1 class="mt-4 ml-2" >Categories</h1>

<div class="list-group">

	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item font-weight-bold">${category.name}</a>
	</c:forEach>
</div>


