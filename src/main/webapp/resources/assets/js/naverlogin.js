 var loginPopup
// loginPopup.addEventListener('beforeunload',()=>{
    
// })

// var timer=setInterval(function(){
//     if(loginPopup.close){
//         clearInterval(timer);
//         location.href="redirect:/main/home"
//     }
// },10000);
function showLoginPopup(){
    let uri = 'https://nid.naver.com/oauth2.0/authorize?' +
        'response_type=code' +                  // 인증과정에 대한 내부 구분값 code 로 전공 (고정값)
        '&client_id=iOyj4IPZB8TA6_rXZWI4' +     // 발급받은 client_id 를 입력
        '&state=NAVER_LOGIN_TEST' +             // CORS 를 방지하기 위한 특정 토큰값(임의값 사용)
        '&redirect_uri=http://localhost:8080/member/login/oauth2/code/naver';   // 어플케이션에서 등록했던 CallBack URL를 입력
    //location.href=uri               
    // 사용자가 사용하기 편하게끔 팝업창으로 띄어준다.
     window.loginPopup= window.open(uri, "Naver Login Test PopupScreen", "width=450, height=600");
    // opener.location.href="redirect:/main/home";
    // self.close();
}