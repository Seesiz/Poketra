<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Matiere" %>
<% List<Matiere> allMatiere = (List<Matiere>) request.getAttribute("matieres"); %>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de prix:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/prixMatiere">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="matie">Matiere:</label>
            <select class="form-select" id="matie" name="matiere">
                <option selected disabled>Choix du matiere</option>
                <% for(Matiere t : allMatiere){ %>
                    <option value="<%=t.getMat_id() %>"><%=t.getMat_nom()%></option>
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
            url: '/prixMatiere/'+$("#min").val()+'/'+$("#max").val(),
            success: function(response){
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.sacNom+"</td>");
                    var td2 = $("<td>"+item.sacPrix+"</td>");
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