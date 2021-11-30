// loader

$(window).on("load", () => {
  $(".loader-wrapper").fadeOut("slow");
});

// glider 

window.addEventListener('load', function(){
    new Glider(document.querySelector('.glider'), {
        slidesToScroll: 'auto',
        slidesToShow: 1,
        duration: 1,
        draggable: true,
        dragVelocity: 1,
        arrows: {
          prev: '.glider-prev',
          next: '.glider-next'
        },
        responsive: [
            {
              // screens greater than >= 775px
              breakpoint: 775,
              settings: {
                // Set to `auto` and provide item width to adjust to viewport
                slidesToShow: 'auto',
                slidesToScroll: 'auto',
                itemWidth: 150,
                duration: 1
              }
            },{
              // screens greater than >= 1024px
              breakpoint: 1024,
              settings: {
                slidesToShow: 'auto',
                slidesToScroll: 'auto',
                itemWidth: 150,
                duration: 1
              }
            }
          ]
      });
  });

  // scroll AOS

  AOS.init();

  /*  */

   const cursor = document.querySelector('.cursor');

	
		document.addEventListener('mousemove', e => {
            cursor.setAttribute("style", "top: "+(e.pageY - 10)+"px; left: "+(e.pageX - 10)+"px;")
        });
		document.addEventListener( 'mouseover', () => {
	cursor.setAttribute("style", "opacity: 0;");
		})




      




