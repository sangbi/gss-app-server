function moveLogin(){
    location.replace('http://localhost:8080/member/login')
}

$(window).on('load',function(){
    $('#myModal').modal('show');
});