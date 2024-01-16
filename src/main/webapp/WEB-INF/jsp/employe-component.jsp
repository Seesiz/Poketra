<%@ page import="com.project.project.Model.Employe" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Sac" %>
<% List<Sac> all = (List<Sac>) request.getAttribute("sacs"); %>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Gestion de duree:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="myForm" method="post" action="/employe">
        <span class="col-12 d-flex flex-column align-items-start">
            <label for="sac">Sac:</label>
            <select name="idsac" id="sac" class="form-control">
                <% for(Sac e : all){ %>
                    <option value="<%=e.getSacId()%>"><%=e.getSacNom()%> <%=e.getSacTaille().getTailleNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="d-flex gap-2 justify-content-evenly mt-2">
            <input type="text" name="designation_Employe" class="form-control" placeholder="Designation">
            <input type="number" name="quantite_Employe" class="form-control" placeholder="Quantite">
            <input type="number" name="duree_Employe" class="form-control" placeholder="Duree">
            <input type="number" name="salaire_Employe" class="form-control" placeholder="Salaire">
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Liste des sacs:</span>
        <span class="col-3 d-flex gap-2 justify-content-evenly align-items-center">
            <select name="sacs" id="sacs" class="form-control">
                <option value="s">Choix de sac</option>
                <% for (Sac s : all){%>
                    <option value="<%=s.getSacId()%>"><%=s.getSacNom()%> <%=s.getSacTaille().getTailleNom()%></option>
                <% } %>
            </select>
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Designation</th>
                <th>Salaire</th>
                <th>Quantite</th>
                <th>Duree</th>
            </tr>
            </thead>
            <tbody id="tbodydata">
            </tbody>
        </table>
    </section>
</div>
<script>
    $("#sacs").change(function(){
        $.ajax({
            type: 'GET',
            url: '/employe/'+$(this).val(),
            success: function(response){
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.designation_Employe+"</td>");
                    var td2 = $("<td>"+item.salaire_Employe+"</td>");
                    var td3 = $("<td>"+item.quantite_Employe+"</td>");
                    var td4= $("<td>"+item.duree_Employe+"</td>");
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