// const banner = document.querySelector("div.banner");
// const image_divs = document.querySelectorAll("div.banner div.image");
// const first_div = document.querySelector("#first-temp");
// const last_div = document.querySelector("#last-temp");
// const prev = document.querySelector("div.prev");
// const next = document.querySelector("div.next");
// const dots = document.querySelectorAll("div.dot");
const $slick_track = $("div.slick-track");
const $image_divs = $("div.slick-track div.image");
const $first_div = $("#first-temp");
const $last_div = $("#last-temp");
const $prev = $("prev");
const $next = $("next");
const $dots = $(".swiper-pagination-bullet");
let count = 0;
let check = true;
let clickCheck = false;

let slide = setInterval(() => {++count, changeBanner(0)}, 2000);

changeButtonStyle();


function changeButtonStyle(){
    $dots.removeClass("active");
    $dots.eq(count - 1).addClass("active");
    clickCheck = true; //선택 버튼이 변경되는 순간 mouseout 이벤트 막기
}


// $dots.hover(function(){
//     $(this).addClass("active");
//     clickCheck = $(this).addClass("active");
// }, function(){
//     if(clickCheck){return;} 
//     $(this).removeClass("active");
//     console.log("mouse out???!!");
// });


$dots.on("click", function(){
    clickCheck = true;
    clearInterval(slide);
    count = parseInt($(this).prop("classList")[1]);
    changeBanner(0);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});


$(".arrow").on("click", function(){
    if(!check) {return;}
    check = false;
    const arrow = {next: 0, prev: 1};
    let direction = arrow[$(this).prop("classList")[1]];
    clearInterval(slide);
    count += direction ? -1 : 1;
    changeBanner(direction);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

// 정방향: 0, 역방향: 1
function changeBanner(direction){
    check = false;
    const array = [[3, -1903, 0], [0, -1903 * $image_divs.length, $image_divs.length]];
    $slick_track.css("transform", `translate(${-1903 * count}px)`);
    $slick_track.css("transition", "transform 0.7s");
    
    if(count == array[direction][0]) {
        setTimeout(() => {
            $slick_track.css("transform", `translate(${array[direction][0]}px)`);
            $slick_track.css("transition", "transform 0s");
        }, 700);
        count = array[direction][2];
    }
    changeButtonStyle();
    setTimeout(() => {
        check = true;
    }, 700);
}