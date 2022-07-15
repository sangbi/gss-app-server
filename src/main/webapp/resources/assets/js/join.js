var newWindow;
var idcheck;


$(document).ready(function(){
	$('#idcheck').click(function(){
 var id=$('#inputID').val();
 if(id == ""){
	alert("ID를 입력해주세요");
}else{
	$.ajax({
		type:"POST",
		url :"/space/CheckID",
		data :{userId: id},
		dataType : "html",
		success : function(result){
			if(result == "false"){
				$("#IDResultflage").html(result);
				console.log("true")
				alert(id+"는 사용 할 수 있는 ID 입니다!");
			}else{
				console.log("false")
				alert("사용할 수 없는 ID 입니다.")
			}
		}
	});
}
});
});

function getContextPath(){
	var hostIndex= location.href.indexOf(location.host)+location.host.length;
	var contextPath=location.href.substring(hostIndex, location.href.indexOf('/',hostIndex+1));
	return contextPath;
}

function join(){
	var today=new Date();
	var pwdCheck= /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
	var reg = (/^01[0179][0-9]{7,8}$/);
	var emailCheck=/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	var brithCheck=/^(19|20)[0-9]{2}(-)(0[1-9]|1[0-2])(-)(0[1-9]|[1-2][0-9]|3[0-1])$/;
	var yearCheck=(document.joinForm.brith.value.split('-',1));
	var rightYear=today.getFullYear();
	if(document.joinForm.inputID.value==""){
		alert("ID를 입력해주세요");
	}else if(document.joinForm.IDResultflage.value=="true"){
		alert("사용 불가능한 ID입니다.\n입력하신 ID를 변경 후 다시 확인 바랍니다.");
	}else if(document.joinForm.inputPassword.value==""){
		alert("PW를 입력해주세요");
	}else if(!pwdCheck.test(document.joinForm.inputPassword.value)){
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
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
	}else if(document.joinForm.brith.value==""){
		alert("생년월일을 입력해주세요");
	}else if(!brithCheck.test(document.joinForm.brith.value)){
		alert("생년월일 형식을 확인해주세요");
	}else if(yearCheck>rightYear){
		alert("생년월일을 확인해주세요")
	}else if(document.joinForm.gender.value==""){
		alert("성별을 선택해주세요");
	}else if(document.joinForm.email.value==""){
		alert("E-Mail을 입력해주세요");
	}else if(!emailCheck.test(document.joinForm.email.value)){
		alert("E-Mail 형식 문제");
	}
	var conPath=getContextPath();
	window.location.href=conPath+"/joinPro.do"
}

function setParentText(){
	opener.document.getElementById("pInput").value=document.getElementById("cInput").value
}
function closeCheckID(){
	newWindow.document.getElementById("ID").value=document.getElementById("id").value
	newWindow.document.getElementById("idcheck").value=document.getElementById("idcheck").value
	window.close();
	self.close();
}
function EditCloseCheckID(){
	let id = document.idform.idcheck.value
	let idcheck=document.idform.idcheck.value
	var param={id, idcheck}
	window.parent.postMessage(param,'*');
	window.open("join.jsp?id="+id+"&idcheck="+idcheck, "ID","idcheck");
	//document.getElementById("idcheck").value=document.getElementById("idcheck").value
}
function falsecheck(){
	alert(document.joinForm.idcheck.value);
}
function checkID(){
	let form=document.joinForm;
	let id=document.joinForm.ID.value;
	if(document.joinForm.ID.value==""){
		alert("ID입력을 안했어요");
		document.joinForm.ID.focus();
	}else{
		newWindow=window.open("IDcheck.jsp?id="+id, "ID","width=570,height=350,resizable=no,scrollbars=no");
		//form.action="IDcheck.jsp"
	}
}

function place(){
	document.serveyinfo.age.placeholder="";
}
function placeOver(){
	document.serveyinfo.age.placeholder="연령대를 넣어주세요";
}