function userRegistForm() {
	console.log('userRegistForm()');
	
	let form = document.user_regist_form;
	if (form.uID.value === '') {
		alert('INPUT NEW USER ID!!');
		form.uID.focus();
		
	} else if (form.uPW.value === '') {
		alert('INPUT NEW USER PW!!');
		form.uPW.focus();
		
	} else if (form.uGender.value === '') {
		alert('SELECT NEW USER GENDER!!');
		form.uGender.focus();
		
	} else if (form.uMail.value === '') {
		alert('INPUT NEW USER MAIL!!');
		form.uMail.focus();
		
	} else if (form.uPhone.value === '') {
		alert('INPUT NEW USER PHONE!!');
		form.uPhone.focus();
		
	} else {
		form.submit();
		
	}
	
}

function userLoginForm() {
	console.log('userLoginForm()');
	
	let form = document.user_login_form;
	if (form.uID.value === '') {
		alert('INPUT USER ID!!');
		form.uID.focus();
		
	} else if (form.uPW.value === '') {
		alert('INPUT USER PW!!');
		form.uPW.focus();
		
	} else {
		form.submit();
		
	}
	
}

function userModifyForm() {
	console.log('userModifyForm()');
	
	let form = document.user_modify_form;
	if (form.uPW.value === '') {
		alert('INPUT USER PW!!');
		form.uPW.focus();
		
	} else if (form.uGender.value === '') {
		alert('SELECT USER GENDER!!');
		form.uGender.focus();
		
	} else if (form.uMail.value === '') {
		alert('INPUT USER MAIL!!');
		form.uMail.focus();
		
	} else if (form.uPhone.value === '') {
		alert('INPUT USER PHONE!!');
		form.uPhone.focus();
		
	} else {
		form.submit();
		
	}
	
}
