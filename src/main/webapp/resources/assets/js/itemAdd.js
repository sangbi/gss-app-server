function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
const inputImage = document.getElementById("input-image")
console.log(inputImage);
inputImage.addEventListener("change", e => {
    readImage(e.target)
})

function addModalItem(row){
	var tagTd = row.getElementsByTagName('td')
    var itemName = tagTd[0].innerText
    var modalItem = document.getElementById('modalItem')    
    var newRow = modalItem.insertRow(10)
    var text = document.createTextNode(itemName)
    var eleInput = document.createElement('input')
    eleInput.type = 'number'
    var newCell1 = newRow.insertCell(0)
    var newCell2 = newRow.insertCell(1)
    eleInput.className = 'inputPrice'
    newCell1.innerText = text.nodeValue
    newCell1.className ='itemName'
    newCell2.appendChild(eleInput)
}

function priceList(partyName){
    var itemNamelist = $('.itemName')
    var itemPricelist = $('.inputPrice')
    var itemNamelistValue = []
    var itemPricelistValue = []

    for(var i=0;i<itemPricelist.length;i++){
        itemNamelistValue[i] = itemNamelist[i].innerText
        itemPricelistValue[i] = itemPricelist[i].value
        console.log(`${itemNamelist[i].innerText} : ${itemPricelist[i].value}`)
    }
    console.log(partyName)
    $.ajax({
        url:'http://localhost:8080/calculate/calcInsert',
        type:'post',
        traditional: true,
        data:{itemName : itemNamelistValue,
            itemPrice : itemPricelistValue,
            partyName : partyName},
        success:function(data){
            console.log(data)
            if(data>0){
                return true
            }else{
                return false
            }
        }
    });
}

function checkRatio(form){
    var ratioList = form.ratio
    var sum = 0;
    for (var i = 0; i<ratioList.length;i++){
        sum += parseInt(ratioList[i].value)
    }
    console.log(sum)

    if (sum != 100){ 
        $("#errorMessage").css("font-size", "20px")   
        $("#errorMessage").css("display", "block")
        $("#errorMessage").text("비율 합이 100이 아닙니다")
    } else {
        form.submit()
    }
}

function searchItem(form){
    var itemName = form.itemName.value

    $.ajax({
        url:'http://localhost:8080/calculate/itemSearch',
        type:'post',
        traditional: true,
        data:{itemName : itemName
        },
        success:function(data){
            console.log(data)
            if(data>0){
                return data
            }else{
                return data
            }
        }
    });
}

function moveCalculateList(form){
    var partyName = form.partyName.value
    console.log(partyName)
    $.ajax({
        url:'http://localhost:8080/calculate/calculateList',
        type:'get',
        data:{partyName : partyName
        },
        success:function(data){
        }
    });
}

function moveToCalculateCompleteList(form){
    var partyName = form.partyName.value
    console.log(partyName)
    $.ajax({
        url:'http://localhost:8080/calculate/calculateCompleteList',
        type:'get',
        data:{partyName : partyName
        },
        success:function(data){
        }
    });
}
function moveToPartyList(id){
    console.log(id);
    $.ajax({
        url:'http://localhost:8080/calculate/partyList',
        type:'post',
        data:{userId:id
        }
    });
}

function moveToCalculateComplete(form){
    var userId = form.userId.value
    form.method = "post";
    form.action = "/calculate/calculateComplete";
    $.ajax({
        url:'http://localhost:8080/calculate/calculateComplete',
        type:'post',
        data:{userId:userId
        },
        success:function(data){
            form.submit();
        }
    });
}
