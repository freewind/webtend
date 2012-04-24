$.ajaxSetup({
	error : function(xhr, textStatus, errorThrown) {
		document.write(xhr.responseText);
	}
});
