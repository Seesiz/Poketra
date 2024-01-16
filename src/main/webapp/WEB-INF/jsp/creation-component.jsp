<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Look" %>
<%@ page import="com.project.project.Model.Type" %>
<%@ page import="com.project.project.Model.Taille" %>
<%@ page import="com.project.project.Model.Matiere" %>
<% List<Look> allLook = (List<Look>) request.getAttribute("look");%>
<% List<Type> allType = (List<Type>) request.getAttribute("type");%>
<% List<Taille> allTaille = (List<Taille>) request.getAttribute("taille");%>
<% List<Matiere> allMatiere = (List<Matiere>) request.getAttribute("matiere");%>
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
            <label for="taillei">Taille:</label>
            <select class="form-select" id="taillei" name="taille">
                <option selected disabled>Choix du taille</option>
                <% for(Taille t : allTaille){ %>
                    <option value="<%=t.getTailleId() %>"><%=t.getTailleNom()%></option>
                <% } %>
            </select>
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
        <span class="col-12 d-flex flex-column align-items-start">
            <label>Matiere:</label>
            <ul class="list-group col-12" id="lookList" style="max-height: 20rem; overflow-y: auto">
            </ul>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Liste des sacs:</span>
        <span class="col-2">
            <select class="form-select" id="matiereinput">
                <option disabled selected>Choix de matiere</option>
                <% for(Matiere m : allMatiere) { %>
                    <option value="<%=m.getMat_id()%>"><%=m.getMat_nom()%></option>
                <% } %>
            </select>
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
            <tr>
                <th>Sac</th>
                <th>Type</th>
                <th>Taille</th>
            </tr>
            </thead>
            <tbody id="tbodydata">

            </tbody>
        </table>
    </section>
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
                    var newCheck = $("<input checked>");
                    var newInput = $("<input>");
                    var spanCheck = $("<label></label>");
                    var spanQuantite = $("<span></span>")
                    newLook.attr("class", "list-group-item d-flex gap-2 align-items-center");
                    spanCheck.text(matiere.mat_nom);
                    newCheck.attr("value", matiere.mat_id);
                    newCheck.attr("type", "checkbox");
                    newCheck.attr("class", "form-check-input itemlist")
                    newCheck.attr("name", "matiere");
                    newCheck.attr("id", matiere.mat_id+matiere.mat_nom);
                    spanCheck.attr("for", matiere.mat_id+matiere.mat_nom);
                    newInput.attr("class", "form-control bg-white");
                    newInput.attr("type", "number");
                    newInput.attr("name", "q_"+matiere.mat_id);
                    newLook.attr("class", "d-flex justify-content-between align-items-center p-2 gap-2");
                    $.ajax({
                        type: 'POST',
                        data: {
                            idMatLook: item.matdet_id,
                            idTaille: $("#taillei").val()
                        },
                        url: '/quantite/quant',
                        success: function(response){
                            if(response.quantite != null){
                                newInput.attr("value", response.quantite.quanValue);
                            } else {
                                newInput.attr("value", 0);
                            }
                        },
                        error: function(response){
                            console.log(response);
                        }
                    });
                    newLook.append(newCheck);
                    newLook.append(spanCheck);
                    newLook.append(newInput);
                    $("#lookList").append(newLook);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
    });

    $("#matiereinput").change(function(){
        $.ajax({
            type: 'GET',
            url: '/creation/'+$(this).val(),
            success: function(response){
                console.log(response);
                $("#tbodydata").text("");
                for (let item of response){
                    var tr = $("<tr></tr>");
                    var td1 = $("<td>"+item.sacSac.sacNom+"</td>");
                    var td2 = $("<td>"+item.sacSac.sacType.typeNom+"</td>");
                    var td3 = $("<td>"+item.sacSac.sacTaille.tailleNom+"</td>");
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    $("#tbodydata").append(tr);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
    });
</script>