window.addEventListener('load', ()=> {
    var tiempo = setInterval(function(){
        let hora = document.getElementById('hora');
        let date = new Date();
        if(date.getMinutes()<10){
            hora.textContent = date.getHours() + ":0" + date.getMinutes();
        }else{
            hora.textContent = date.getHours() + ":" + date.getMinutes();
        }
    }, 1000)
})