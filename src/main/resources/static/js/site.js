$(function () {
    $(document).ready(function () {
        $('#updateEventLog').on('click', function (event) {
            $.get("/getEventLog", function (data) {
                if (!!data) {
                    var html = "";
                    data.forEach(function (d, i) {
                        html += "<li>" + d + "</li>\n";
                    });
                    $('#eventLogListContainer').html(html);
                }

            });
        });

        $('#peerListTable').DataTable({

        });


        $('#detailsTable').DataTable({

        });


    });
});
