//도시락 버튼
$dosirakBtns = $(".dosirack")
$deleteBtns = $(".btn-wrapper")

$dosirakBtns.each((i,btn)=>{
    $(btn).on("click",e=>{
        $deleteBtns.eq(i).toggle()
    })
})