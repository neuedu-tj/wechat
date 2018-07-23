


$(window).keyup(function(e){

    //清空 result 层中的子元素
    $("#result").empty();

   if( e.keyCode == 13) { //回车

   } else if(e.keyCode == 38) { //up

   } else if(e.keyCode ==40) { //down

   } else {
      $.ajax({
          url : 'http://localhost:8080/wechat/auto?name='+$("#name").val(),
          method : 'get',
          dataType : 'json',
          success : function(data) {

              $.each(data , function( i, e ) {
                 var item = $("<div>"+e.name+"</div>").addClass("item-normal")
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
