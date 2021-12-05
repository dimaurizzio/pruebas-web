// loader

$(window).on("load", () => {
  $(".loader-wrapper").fadeOut("slow");
});

   const cursor = document.querySelector('.cursor');

	
		document.addEventListener('mousemove', e => {
            cursor.setAttribute("style", "top: "+(e.pageY - 10)+"px; left: "+(e.pageX - 10)+"px;")
        });
		document.addEventListener( 'mouseover', () => {
	cursor.setAttribute("style", "opacity: 0;");
		})




      




