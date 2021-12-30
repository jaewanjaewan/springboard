function moveToDetail(iboard){
    location.href='/board/detail?iboard=' + iboard;
}

let trList = document.querySelectorAll('.record');
for(let i=0; i<trList.length; i++){ /*let of로도 해보기*/
    let tr = trList[i];
    tr.addEventListener('click', function () {
       moveToDetail(tr.dataset.iboard);
    });
}