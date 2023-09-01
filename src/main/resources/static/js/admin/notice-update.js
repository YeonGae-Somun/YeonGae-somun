const $title = document.querySelector(".ChangeTitle");
const $sideList = document.querySelectorAll(".mainNav>li");
// const writeForm = document.querySelector(".btn.btn-write");

$sideList.forEach(el =>{
    if(el.innerText == $title.innerText){
        el.style.background="#7aab9a";
        el.firstChild.style.color ="white";
    }
})
// console.log("testttttttt", writeForm);
//
// writeForm.addEventListener('click', e => {
//     let button = [];
//
//     fetch("/admin/update", {
//         method: "POST",
//         headers: {"Content-type": "application/json;charset=utf-8"},
//         body: JSON.stringify(button)
//     }).then(() => location.href = "/admin/notice");
// })