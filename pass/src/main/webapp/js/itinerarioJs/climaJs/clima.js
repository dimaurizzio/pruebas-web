window.addEventListener('load', ()=> {
    let lon
    let lat
    let APIKEY = 'a7e81f51e6fcacb7610b8d15924579d7'
    
    let temperaturaValor = document.getElementById('temperatura-valor');
    let temperaturaDescripcion = document.getElementById('temperatura-descripcion');

    let ubicacion = document.getElementById('ubicacion');
    let iconoAnimado = document.getElementById('icono-animado');

    let vientoVelocidad = document.getElementById('viento-velocidad');

    let date = new Date();

    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition( posicion => {
        lon = posicion.coords.longitude
        lat = posicion.coords.latitude

        const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${APIKEY}&lang=es&units=metric`
        console.log(url)
        fetch(url)
            .then( response => { return response.json() })
            .then( data => {
                console.log(data.main.temp)
                let temp = Math.round(data.main.temp)
                temperaturaValor.textContent = `${temp} ° C`
                
                let desc = data.weather[0].description
                temperaturaDescripcion.textContent = desc.toUpperCase()
               
                ubicacion.textContent = data.name
               
				vientoVelocidad.textContent = `${Math.trunc(data.wind.speed*3.6)} km/h`
				
                console.log(data.weather[0].main)
                switch(data.weather[0].main){
                    case 'Clear':
                        if(date.getHours()<6||date.getHours()>20){
                            iconoAnimado.src = 'animated/night.svg'
                        }else{
                            iconoAnimado.src = 'animated/day.svg'
                        }
                        break;
                    case 'Clouds':
                        if(date.getHours()<6||date.getHours()>20){
                            iconoAnimado.src = 'animated/cloudy-night-1.svg'
                        }else{
                            iconoAnimado.src = 'animated/cloudy-day-1.svg'
                        }
                        break;
                    case 'Thunderstorm':
                        iconoAnimado.src = 'animated/thunder.svg'
                        break;
                    case 'Drizzle':
                        if(date.getHours()<6||date.getHours()>20){
                            iconoAnimado.src = 'animated/rainy-4.svg'
                        }else{
                            iconoAnimado.src = 'animated/rainy-2.svg'
                        }
                        break;
                    case 'Rain':
                        iconoAnimado.src = "animated/rainy-7.svg"
                        break;
                    case 'Snow':
                        iconoAnimado.src = "animated/snowy-6.svg"
                        break;
                    case 'Atmosphere':
                        iconoAnimado.src = "animated/weather.svg"
                        break;
                    default:
                        if(date.getHours()<6||date.getHours()>20){
                            iconoAnimado.src = 'animated/cloudy-night-1.svg'
                        }else{
                            iconoAnimado.src = 'animated/cloudy-day-1.svg'
                        }
                        break;
                }

            })
            .catch( error => {
                console.log(error)
            })
        })
          
    }
})
