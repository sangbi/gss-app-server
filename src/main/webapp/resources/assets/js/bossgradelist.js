$(document).ready(function(){
    $('#bossName').click(function(){
        var bossName=$('#bossName').val();
        var $target=$("select[id='bossGrade']");
        var $list=$("select[id='bossGrade']").children('option:not(:first)');
        $list.remove();
        if(bossName !==""){
            $.ajax({
                type:"POST",
                url :"/bossGradeList",
                data :{choiceBossName: bossName},
                traditional: true,
                dataType : "html",
                success : function(gradeList){
                    var gradeData=JSON.parse(gradeList);
                        var v=v;
                        for(var i=0; i<gradeData.length; i++){
                            $target.append("<option id="+v+" value="+gradeData[i]+">"+gradeData[i]+"</option");
                        }
                }
            });
        }
    });
});