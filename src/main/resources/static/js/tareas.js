// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarTareas();
    $('#tareas').DataTable();
});

async function cargarTareas(){

  const request = await fetch('api/tareas', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
    const tareas = await request.json();
    let listadoHtml = '';
  for(let tarea of tareas)
  {
    let botonEliminar = '<a href="#" onclick="eliminartarea('+ tarea.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let tareaHtml = '<tr><td>'+ tarea.id +'</td><td>'+ tarea.actividad +'</td><td>'+ tarea.fecha +'</td></tr>';
    listadoHtml += tareaHtml;
  }
  document.querySelector('#tareas tbody').outerHTML = listadoHtml;
}

async function eliminartarea(id)
{
    if(!confirm('¿Desea Eliminar tarea '+ id +'?')){
     return;
    }
    const request = await fetch('api/tareas/'+ id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      location.reload();
}
