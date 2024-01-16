<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Matiere" %>
<%@ page import="com.project.project.Model.Sac" %>
<% List<Sac> allMatiere = (List<Sac>) request.getAttribute("sacs"); %>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de prix de vente:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/benefice">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="sac">Sac:</label>
            <select class="form-select" id="sac" name="sac">
                <option selected disabled>Choix du sac</option>
                <% for(Sac t : allMatiere){ %>
                    <option value="<%=t.getSacId() %>"><%=t.getSacNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="prix">Prix:</label>
            <input type="number" min="0" name="prix" id="prix" class="form-control" value="0"/>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Liste des sacs:</span>
        <span class="col-7 d-flex gap-2 justify-content-evenly align-items-center">
            <label for="min">Min:</label>
            <input type="number" id="min" name="min" class="form-control" min="0" value="0">
            <label for="max">Max:</label>
            <input type="number" id="max" name="max" class="form-control" min="0" value="0">
            <button class="btn btn-primary" id="filtre">Filter</button>
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Sac</th>
                <th>Prix</th>
            </tr>
            </thead>
            <tbody id="tbodydata">
            </tbody>
        </table>
    </section>
</div>
<script>
    $("#filtre").click(function(){
        $.ajax({
            type: 'GET',
            url: '/benefice/'+$("#min").val()+'/'+$("#max").val(),
            success: function(response){
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.sac_nom+"</td>");
                    var td2 = $("<td>"+item.benefice+"</td>");
                    tr.append(td1);
                    tr.append(td2);
                    $("#tbodydata").append(tr);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
    });
</script>