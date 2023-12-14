<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Look" %>
<%@ page import="com.project.project.Model.Type" %>
<%@ page import="com.project.project.Model.Taille" %>
<% List<Look> allLook = (List<Look>) request.getAttribute("look");%>
<% List<Type> allType = (List<Type>) request.getAttribute("type");%>
<% List<Taille> allTaille = (List<Taille>) request.getAttribute("taille");%>
<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de sac:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/creation">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="name">Nom:</label>
            <input type="text" name="nom" id="name" class="form-control" placeholder="Nom">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="looki">Look:</label>
            <select class="form-select" id="looki" name="look">
                <option selected disabled>Choix du look</option>
                <% for(Look l : allLook){ %>
                    <option value="<%=l.getLookId() %>"><%=l.getLook_nom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="typei">Type:</label>
            <select class="form-select" id="typei" name="type">
                <option selected disabled>Choix du type</option>
                <% for(Type t : allType){ %>
                    <option value="<%=t.getTypeId() %>"><%=t.getTypeNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="taillei">Taille:</label>
            <select class="form-select" id="taillei" name="taille">
                <option selected disabled>Choix du taille</option>
                <% for(Taille t : allTaille){ %>
                    <option value="<%=t.getTailleId() %>"><%=t.getTailleNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="prix">Prix:</label>
            <input type="number" class="form-control" id="prix" name="prix">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label>Matiere:</label>
            <ul class="list-group col-12" id="lookList" style="max-height: 20rem; overflow-y: auto">
            </ul>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<script>
    $("#looki").change(function(){
        $.ajax({
            type: 'GET',
            url: '/matlook/'+$(this).val(),
            success: function(response){
                $("#lookList").text("");
                for (let item of response){
                    var matiere = item.matdet_matiere;
                    var newLook = $("<li></li>");
                    var newCheck = $("<input>");
                    var spanCheck = $("<label></label>");
                    newLook.attr("class", "list-group-item d-flex gap-2 align-items-center");
                    spanCheck.text(matiere.mat_nom);
                    newCheck.attr("value", matiere.mat_id);
                    newCheck.attr("type", "checkbox");
                    newCheck.attr("class", "form-check-input itemlist")
                    newCheck.attr("name", "matiere");
                    newCheck.attr("id", matiere.mat_id+matiere.mat_nom);
                    spanCheck.attr("for", matiere.mat_id+matiere.mat_nom)
                    newLook.append(newCheck);
                    newLook.append(spanCheck);
                    $("#lookList").append(newLook);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
    });
</script>