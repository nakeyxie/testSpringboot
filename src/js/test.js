/*
//濮濐槓s娑撶儤?閻ㄥ埊s閿涘本婀佸鍫濐樋閸忣剛鏁ら弬瑙勭《
function changeDivContent(divId,requestUrl,target){
    $.ajax({
        type : "POST",
        url : requestUrl,
        async : true,
        dataType : "html",
        success : function(result) {
            $("#" + divId).html(result);
        }
    });
}

function delElement(id) {
    $("#"+id).remove();
}

/!*$("#moreId-l").ready(function(){
 //鐎涳妇鏁撴径纾嬪綅閸楁洖濮炴潪?		$(".l11").css("display","inline");
 $(".l22").css("display","inline");
 $(".l33").css("display","inline");
 $(".l44").css("display","inline");
 $(".l444").css("display","inline");
 $(".l55").css("display","inline");
 //閺佹瑥绗€婢剁褰嶉崡鏇炲鏉?		$(".tl11").css("display","inline");
 $(".tl22").css("display","inline");
 $(".tl33").css("display","inline");
 $(".tl44").css("display","inline");
 $(".tl444").css("display","inline");
 $(".tl55").css("display","inline");
 $(".tl555").css("display","inline");
 $("#moreId-l").css("display","inline");
 //閸掑棜椴搁悳鍥с亣娴?024閿涘苯鍙忛柈銊︽▔缁€?		if(window.screen.width > 1024){
 $(".l66").css("display","inline");
 $(".l77").css("display","inline");
 $(".l88").css("display","inline");
 $(".tl66").css("display","inline");
 $(".tl88").css("display","inline");
 $(".tl99").css("display","inline");
 $(".tl10").css("display","inline");
 //缁夊娅庨弴纾嬬箖
 $("#li_166").remove();
 $("#li_177").remove();
 $("#li_188").remove();
 }else{
 $("#li_166").attr("class","l660");
 $("#li_177").attr("class","l770");
 $("#li_188").attr("class","l880");

 $("#self_id_mo").attr("class","l660");
 //$("#stu_id_mo").attr("class","l770");
 $("#pas_id_mo").attr("class","l880");
 };
 $("#moreId-l").attr("class","l99");
 $("#moreId-l").mouseover(function(){
 $("#Layer1 li").removeClass();
 $("#li_166").attr("class","l660");
 $("#li_177").attr("class","l770");
 $("#li_188").attr("class","l880");
 $("#lij_166").attr("class","l55");
 $("#lij_1666").attr("class","l555");
 $("#lij_1110").attr("class","l110");
 $("#lij_1111").attr("class","l111");
 $("#self_id_mo").attr("class","l660");
 $("#pas_id_mo").attr("class","l880");
 $("#t_change_id").attr("class","tl990");
 $("#t_noteShare_id").attr("class","tl100");
 if(document.all){
 $("#Layer1").attr('class','come_ie');
 }else{
 $("#Layer1").attr('class','come');
 }
 $("#Layer1 li").attr('style','padding-left:0px;');
 });
 $("#moreId-l").mouseout(function(){
 $("#Layer1").attr('class','go');
 });
 });*!/
function showCallTeahcer(){
    tb_show("","#TB_inline?height=310&width=430&inlineId=hidden-box-call-teacher&modal=true",false);
}

//鐎电畠hickbox閸嬫矮鍞惍浣稿瀼閹?
/function replacePrompting(id,content){
$('#' +id).append( $("#TB_ajaxContent").children() );
$("#questionContent").val('');
$("#TB_ajaxContent").append($('#replace-prompting').children());
$('#prompting-message').html( '<span id="note-sure-msg" >'+content+'</span>');

// var hight = $('#TB_ajaxContent').css('height');
//$('#prompting-content').css('height',hight.split('p')[0]-70);
//}

//閸掑洦宕叉稉鍝勭磻婵鐛ユ担鎾虫倵閿涘苯鍙ч梻顓炶剨閸戠儤顢?
/function tbReplaceRemove(prevId,currentId){

$('#' +currentId).append( $("#TB_ajaxContent").children() );
$("#TB_ajaxContent").append($('#'+prevId).children());
tb_remove();

}



*/
