window.onload=function(){
   var certificationFlag= document.getElementById("certificationFlag");
   certificationFlag.setAttribute('value','');
}
$(document).ready(function(){
	$('#sendEmail').click(function(){
 var userinputemail=$('#email').val();
 if(userinputemail == ""){
	alert("email을 입력해주세요");
}else{
    alert("인증번호를 발송하였습니다!");
	$.ajax({
		type:"POST",
		url :"/member/email",
		data :{userEmail: userinputemail},
		dataType : "html",
	});
}
});
});


$(document).ready(function(){
	$('#certificationEmailConfirm').click(function(){
 var certificationNumber=$('#certificationNumber').val();
 var userinputemail=$('#email').val();
 if(certificationNumber == ""){
	alert("인증번호를 입력해주세요");
}else{
	$.ajax({
		type:"POST",
		url :"/member/cerEmail",
		data :{cerNumber: certificationNumber, inputEmail: userinputemail},
		dataType : "html",
		success : function(result){
			if(result == "true"){
				$("#certificationFlag").attr('value',result);
				alert("인증이 완료 되었습니다!");
			}else{
                $("#certificationFlag").attr('value',result);
				alert("인증에 실패했습니다.\n다시한번 인증 해주세요")
			}
		}
	});
}
});
});

// $(document).ready(function(){
//     $('#submit').click(function(){
// var certificationFlag=$('#certificationFlag').val();
// if(certificationFlag =='true'){
//     join();
   
// }
// });
// });


function join(){
	var pwdCheck= /^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$/;
	var emailCheck=/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$/;
    var phoneCheck=/^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$/;
    if(('#password')==""){
		alert("PW를 입력해주세요");
	}else if(!pwdCheck.test(document.joinForm.inputPassword.value)){
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~16자리 사용해야 합니다.");
	}else if(document.joinForm.inputPassword2.value==""){
		alert("PW 확인을 입력해주세요");
	}else if(document.joinForm.inputPassword2.value!=document.joinForm.inputPassword.value){
		alert("PW의 입력값과 PW 확인의 입력값이 다릅니다.");
	}else if(document.joinForm.name.value==""){
		alert("이름을 입력해주세요");
	}else if(document.joinForm.nickname.value==""){
		alert("닉네임을 입력해주세요");
	}else if(document.joinForm.phone.value==""){
		alert("휴대폰 번호를 입력해주세요");
	}else if(!reg.test(document.joinForm.phone.value)){
		alert("전화번호는 숫자만 입력할 수 있습니다.");
	}else if(document.joinForm.email.value==""){
		alert("E-Mail을 입력해주세요");
	}else if(!emailCheck.test(document.joinForm.email.value)){
		alert("E-Mail 형식 문제");
	}else{
        alert("정보를 수정하겠습니다.");
    }
}
