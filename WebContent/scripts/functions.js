validateLogin = function(form) {

	if (form.userName.value.trim().length == 0) {
		alert("Enter user Name");
		return false;
	} else if (form.password.value.trim().length == 0) {
		alert("Enter password");
		return false;
	}
	
	return true;
};

