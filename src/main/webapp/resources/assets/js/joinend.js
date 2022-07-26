function moveLogin(){
    location.replace('http://localhost:8080/member/login')
}

function moveHome(){
    location.replace('http://localhost:8080/main/home')
}


$(window).on('load',function(){
    $('#myModal').modal('show');
});
