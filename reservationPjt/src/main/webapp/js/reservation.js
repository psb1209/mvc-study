function reservationForm() {
	console.log('reservationForm()');
	
	let form = document.reservation_form;
	if (form.rName.value === '') {
		alert('Input reservation name!');
		form.rName.focus();
		
	} else if (form.rMail.value === '') {
		alert('Input reservation mail!');
		form.rMail.focus();
		
	} else if (form.rPhone.value === '') {
		alert('Input reservation phone!');
		form.rPhone.focus();
		
	} else if (form.departLocationNo.value === '') {
		alert('Select reservation departLocation!');
		form.departLocationNo.focus();
		
	} else if (form.rDepartDateTime.value === '') {
		alert('Select reservation departdatetime!');
		form.rDepartDateTime.focus();
		
	} else if (form.arrivalLocationNo.value === '') {
		alert('Select reservation arrivalLocation!');
		form.arrivalLocationNo.focus();
		
	} else if (form.rArrivalDateTime.value === '') {
		alert('Select reservation arrivaldatetime!');
		form.rArrivalDateTime.focus();
		
	} else {
		form.submit();
		
	}
	
}

function reservationModifyForm() {
	console.log('reservationModifyForm()');
	
	let form = document.reservation_modify_form;
	if (form.rName.value === '') {
		alert('Input reservation name!');
		form.rName.focus();
		
	} else if (form.rMail.value === '') {
		alert('Input reservation mail!');
		form.rMail.focus();
		
	} else if (form.rPhone.value === '') {
		alert('Input reservation phone!');
		form.rPhone.focus();
		
	} else if (form.departLocationNo.value === '') {
		alert('Select reservation departLocation!');
		form.departLocationNo.focus();
		
	} else if (form.rDepartDateTime.value === '') {
		alert('Select reservation departdatetime!');
		form.rDepartDateTime.focus();
		
	} else if (form.arrivalLocationNo.value === '') {
		alert('Select reservation arrivalLocation!');
		form.arrivalLocationNo.focus();
		
	} else if (form.rArrivalDateTime.value === '') {
		alert('Select reservation arrivaldatetime!');
		form.rArrivalDateTime.focus();
		
	} else {
		form.submit();
		
	}
	
}

function reservationCancel(context_path, r_no) {
	console.log('reservationCancel()');
	
	let result = confirm('예약을 정말 취소 하시겠습니까?');
	if (result) {
		location.href = context_path + '/reservation_cancel_confirm.air?rNo=' + r_no;
		
	}
	
}