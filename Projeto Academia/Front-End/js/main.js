$(document).ready(function(){
  $('.menu a').click(function(event){
    event.preventDefault();
    $('#nav-icon3').toggleClass('open');
    if ( $('.open').length ){
      $('.popup__bottom').css({bottom: "-125px"})
      $('.popup__bottom').animate({bottom: "0px"}, 500 );
    }
    $('.popup').fadeToggle();
    $('.site__top').toggleClass('site__open');
  });
  
});