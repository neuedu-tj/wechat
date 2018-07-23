var index = 0;
var total = 0;
$(window).keyup(function(e){
   if( e.keyCode == 13) { //回车
       $("#name").val($(".selected").text());
       $("#result").empty();
       index = 0;
   } else if(e.keyCode == 38) { //up
       if(index == 0) return ;
       $(".item").addClass("normal").removeClass("selected")
       $(".item:nth-child("+(--index)+")").addClass("selected").removeClass("normal")
   } else if(e.keyCode ==40) { //down
       if(index == total) return ;
       $(".item").addClass("normal").removeClass("selected")
       $(".item:nth-child("+(++index)+")").addClass("selected").removeClass("normal")
   } else {
       $("#result").empty();
      $.ajax({
          url : 'http://localhost:8080/wechat/auto?name='+$("#name").val(),
          method : 'get',
          dataType : 'json',
          success : function(data) {

              total = data.length;
              $.each(data.sort() , function( i, e ) {
                 var item = $("<div>"+e.name+"</div>").addClass("item").addClass("normal")
                  item.click(function(){
                      $("#name").val(e.name);
                      $("#result").empty();
                  })
                  $("#result").append(item);;
              })
          }
      })
   }
})