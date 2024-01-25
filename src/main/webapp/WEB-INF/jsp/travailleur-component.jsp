<%@ page import="com.project.project.Model.Poste" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Salaire" %>
<% List<Poste> allPoste = (List<Poste>) request.getAttribute("postes");%>
<% List<Salaire> allTravailleur = (List<Salaire>) request.getAttribute("employers");%>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout d'employer: </span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/travailleur">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="nom">Nom:</label>
            <input class="form-control" id="nom" name="nom" type="text" placeholder="Nom">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="prenom">Prenom:</label>
            <input class="form-control" id="prenom" name="prenom" type="text" placeholder="Prenom">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="date">Date de debut:</label>
            <input class="form-control" id="date" name="date" type="date" placeholder="date">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="postes">Poste:</label>
            <select class="form-select" name="poste" id="postes">
                <% for (Poste p : allPoste){ %>
                    <option value="<%=p.getIdPoste()%>">
                        <%=p.getDesignation()%>
                    </option>
                <% } %>
            </select>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Liste des employer:</span>
        <span class="col-2">
            <input type="search" class="form-control" id="search" placeholder="Recherche">
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Poste</th>
                <th>Salaire</th>
            </tr>
            </thead>
            <tbody id="tbodydata">
            <% for(Salaire s : allTravailleur){%>
                <tr>
                    <td><%=s.getNom()%></td>
                    <td><%=s.getPrenom()%></td>
                    <td><%=s.getDesignation()%> <%=s.getGrade()%></td>
                    <td><%=s.getSalaire()%></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</div>
<script>
    $("#search").keyup(function(){
        let value = "%";
        if($(this).val().trim() != ""){
            value = $(this).val();
        }
        $.ajax({
            type: 'GET',
            url: '/travailleur/'+encodeURIComponent(value),
            success: function(response){
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.nom+"</td>");
                    var td2 = $("<td>"+item.prenom+"</td>");
                    var td3 = $("<td>"+item.designation+' '+item.grade+"</td>");
                    var td4 = $("<td>"+item.salaire+"</td>");
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    $("#tbodydata").append(tr);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
    });
</script>