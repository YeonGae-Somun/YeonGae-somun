//헤더 버튼 클릭
const $tabBtn1 = $(".Tab_tab__zHnkO").eq(0)
const $tabBtn2 = $(".Tab_tab__zHnkO").eq(1)

$tabBtn1.on("click",e=>{
    if(!$tabBtn1.hasClass("Tab_active__1KvvF")){
        $tabBtn2.removeClass("Tab_active__1KvvF")
        $tabBtn1.addClass("Tab_active__1KvvF")
        $(".ignore-container").hide()
        $(".message-container").show()
    }
})


$tabBtn2.on("click",e=>{
    if(!$tabBtn2.hasClass("Tab_active__1KvvF")){
        $tabBtn1.removeClass("Tab_active__1KvvF")
        $tabBtn2.addClass("Tab_active__1KvvF")
        $(".ignore-container").show()
        $(".message-container").hide()
    }
})

//도시락 버튼
$dosirakBtns = $(".dosirack")
$deleteBtns = $(".btn-wrapper")

$dosirakBtns.each((i,btn)=>{
    $(btn).on("click",e=>{
        $deleteBtns.eq(i).toggle()
    })
})