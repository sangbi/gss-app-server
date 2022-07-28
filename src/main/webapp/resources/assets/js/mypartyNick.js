window.onload = function(){ 
    let btns = document.querySelectorAll("#nickBtn");
    console.log(btns);
    for(let i = 0; i < btns.length; i++){
        console.log(btns[i]);
        btns[i].onclick = function(event){
            console.log("event발생객체:" + event.target.id);
            s = event.target.parentElement.parentElement;
            console.log(event.target.parentElement.parentElement.id);
            console.log(s.id);
            console.log("부모:" + s.childNodes[3].id);
            console.log(s.childNodes[3].childNodes[0].value)
            console.log(s.childNodes[5].childNodes[3].value)
            let userNickName=s.childNodes[3].childNodes[0].value
            let userPartyName=s.childNodes[5].childNodes[3].value
            if(userNickName === ""){
                alert("닉네임란을 확인해주세요")
            }else{
                console.log(userPartyName);
                alert("닉네임이 변경 됩니다!")
                location.href="http://localhost:8080/member/editMyPartyNick?partyName="+userPartyName+"&charaterNick="+userNickName
            }
        }
    }
}