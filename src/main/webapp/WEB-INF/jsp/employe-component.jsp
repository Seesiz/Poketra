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
                    <option value="<%=e.getSacId()%>"><%=e.getSacNom()%></option>
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