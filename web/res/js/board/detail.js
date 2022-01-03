let btnContainer = document.querySelector('#btnContainer');
if(btnContainer){
    let btnDel = btnContainer.querySelector('#btnDel');
    btnDel.addEventListener('click', function () {
       if(confirm('삭제 하시겠습니까?')){
           location.href = '/board/del?iboard=' + btnContainer.dataset.iboard; //get방식
       }
    });
}