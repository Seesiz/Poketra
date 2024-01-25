<%@ page import="com.project.project.Model.Sac" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Client" %>
<% List<Sac> allSac = (List<Sac>) request.getAttribute("sacs"); %>
<% List<Client> allClient = (List<Client>) request.getAttribute("clients"); %>

<div class="card col-12 p-0">
    <header class="d-flex flex-row align-items-center gap-2">
        <span style="font-size: 30px">Achat de sac:</span>
        <span>${error}</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/achat">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="client">Client:</label>
            <select id="client" name="client_id" class="form-select">
                <% for (Client c: allClient ) { %>
                    <option value="<%=c.getIdClient()%>"><%=c.getNom()%> <%=c.getPrenom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="sac">Sac:</label>
            <select id="sac" name="sac_id" class="form-select">
                <% for (Sac s: allSac ) { %>
                    <option value="<%=s.getSacId()%>"><%=s.getSacNom()%> <%=s.getSacTaille().getTailleNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="quan">Quantite:</label>
            <input type="number" min="0" name="quan" id="quan" class="form-control" value="0"/>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
