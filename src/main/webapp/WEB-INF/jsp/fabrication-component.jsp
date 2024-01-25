<%@ page import="com.project.project.Model.Sac" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.ResteStockSac" %>
<% List<Sac> allSac = (List<Sac>) request.getAttribute("sacs"); %>
<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Fabrication: </span>${error}
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/fabrication">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="sac">Sac:</label>
            <select class="form-select" id="sac" name="sac">
                <option selected disabled>Choix de sac</option>
                <% for(Sac t : allSac){ %>
                    <option value="<%=t.getSacId() %>"><%=t.getSacNom()%> <%=t.getSacTaille().getTailleNom()%></option>
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
