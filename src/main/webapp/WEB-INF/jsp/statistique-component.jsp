<%@ page import="com.project.project.Model.StatistiqueGenre" %>
<%@ page import="java.util.List" %>
<% List<StatistiqueGenre> allStat = (List<StatistiqueGenre>) request.getAttribute("statistique"); %>

<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Achat par genre par sac:</span>
        <span>
            <input type="search" id="search" name="search" class="form-control" placeholder="Recherche">
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Sac</th>
                <th>Homme</th>
                <th>Femme</th>
            </tr>
            </thead>
            <tbody id="tbodydata">
            <% for(StatistiqueGenre r : allStat){ %>
            <tr>
                <td><%=r.getSacNom()%></td>
                <td><%=r.getHomme()%></td>
                <td><%=r.getFemme()%></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</div>
<div class="card">
    <select class="form-select" id="sac">
        <option disabled selected>Choix sac</option>
        <% for(StatistiqueGenre stat : allStat){ %>
            <option value="<%=stat.getIdSac()%>"><%=stat.getSacNom()%></option>
        <% } %>
    </select>
    <canvas id="myChart" width="150" height="50"></canvas>
</div>

<script>
    $("#sac").change(function() {
        $.ajax({
            type: 'GET',
            url: '/statistique/'+$(this).val(),
            success: function(response){
                var data = {
                    labels: ['Homme', 'Femme'],
                    datasets: [{
                        data:[response.homme,response.femme],
                        backgroundColor: ['blue', 'purple'],
                    }],
                };

                // Options du graphique
                var options = {
                    cutoutPercentage: 50
                };

                var ctx = document.getElementById('myChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'pie',
                    data: data,
                    options: options,
                });
            },
            error: function(response){
                console.log(response);
            }
        });
    });
</script>