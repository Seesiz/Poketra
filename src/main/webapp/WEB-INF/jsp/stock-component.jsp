<%@ page import="com.project.project.Model.Matiere" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Reste" %>
<% List<Matiere> allMatiere = (List<Matiere>) request.getAttribute("matieres");%>
<% List<Reste> allReste = (List<Reste>) request.getAttribute("restes");%>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout en stock:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/stockMatiere">
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
            <label for="quantite">Quantite:</label>
            <input type="number" min="0" name="quantite" id="quantite" class="form-control" value="0"/>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="date">Date:</label>
            <input type="date" name="date" id="date" class="form-control"/>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Stock matiere:</span>
        <span>
            <input type="search" id="search" name="search" class="form-control" placeholder="Recherche">
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Matiere</th>
                <th>Reste</th>
            </tr>
            </thead>
            <tbody id="tbodydata">
            <% for(Reste r : allReste){ %>
            <tr>
                <td><%=r.getMatNom()%></td>
                <td><%=r.getReste()%></td>
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
        console.log(value);
        $.ajax({
            type: 'GET',
            url: '/stockMatiere/'+encodeURIComponent(value),
            success: function(response){
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.matNom+"</td>");
                    var td2 = $("<td>"+item.reste+"</td>");
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