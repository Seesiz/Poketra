<%@ page import="com.project.project.Model.Taille" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Matiere_Look" %>
<% List<Taille> allTaille = (List<Taille>) request.getAttribute("taille");%>
<% List<Matiere_Look> allMatiereLook = (List<Matiere_Look>) request.getAttribute("matiereLook");%>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de quantite:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="secondForm" method="POST" action="/quantite">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="taille">Taille:</label>
            <select class="form-select" id="taille" name="taille">
                <% for(Taille t : allTaille){ %>
                    <option value="<%=t.getTailleId()%>"><%=t.getTailleNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="matlook">Matiere par look:</label>
            <select class="form-select" id="matlook" name="matlook">
                <% for(Matiere_Look ml : allMatiereLook){ %>
                    <option value="<%=ml.getMatdet_id()%>"><%=ml.getMatdet_matiere().getMat_nom()+"-"+ml.getMatdetLook().getLook_nom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="quantite">Quantite:</label>
            <input class="form-control" type="number" name="quantite" id="quantite">
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>