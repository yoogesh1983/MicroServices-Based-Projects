<!DOCTYPE html>
<html>
  <head>
    <style>
#map {
        margin: 0 auto;
        width: 100%;
        height: 240px;
     }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
      function initMap() {
        var myLatLng = {lat: ${model.position.lat}, lng: ${model.position.longitude}};
      
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: myLatLng,
            zoom: 14
        });
        
          var marker = new google.maps.Marker({
    		position: myLatLng,
    		map: map,
    		title: '${model.position.timestamp}'
  		  });               
      }
      
   
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCji5ytQYSzWguHj4vjbEnUcX24tzglekY&callback=initMap">
    </script>
    updated on: ${model.position.timestamp}<br>
  </body>
</html>