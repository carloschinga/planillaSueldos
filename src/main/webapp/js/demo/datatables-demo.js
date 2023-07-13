// Call the dataTables jQuery plugin
$(document).ready(function () {
    $('#dataTable').DataTable({
        ajax: 'listartrabajador',
        columns: [
            {data: 'codiTrab'},
            {data: 'numeDocu'},
            {data: 'appaTrab'},
            {data: 'apmaTrab'},
            {data: 'nombTrab'},
            {data: 'sueldBasi'},
            {data: 'teneAsigFami'}
        ]
    });
});
