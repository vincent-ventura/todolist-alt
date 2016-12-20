$(document).ready(function() {
	$('.button-collapse').sideNav();
	$('select').material_select();
	$('.datepicker').pickadate({
		selectMonths: true,
		selectYears: 15
	});
	
	// get current URL path and assign 'active' class to menu bar
	var pathname = window.location.pathname;
	$('.navbar > li > a[href="'+pathname+'"]').parent().addClass('active');
	
	function checkField(fieldSelector) {
		field = $(fieldSelector);
		if (field.val() == '') {
			field.addClass('invalid');
			return false;
		} else {
			field.removeClass('invalid');
			return true;
		}
	}

	$('form').submit(function() {
		return checkField('#taskName') && checkField('#taskBeginDate');
	});

	$('#taskBeginDate').change(function() {
		checkField('#taskBeginDate');
	});
	$('#taskName').change(function() {
		checkField('#taskName');
	});
})