// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarTarea(){
    let datos = {};
    datos.actividad = document.getElementById('txtActividad').value;
    datos.fecha = document.getElementById('txtfecha').value;


  const request = await fetch('api/tareas', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  location.href ="tareas.html";
}

