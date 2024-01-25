<%@ page import="com.project.project.Model.Sac" %>
<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de client: </span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/client">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="nom">Nom:</label>
            <input type="text" name="nom" placeholder="Nom" id="nom" class="form-control">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="prenom">Prenom:</label>
            <input type="text" name="prenom" placeholder="Nom" id="prenom" class="form-control">
        </span>
        <span class="col-12 d-flex flex-row gap-2 p-2 align-items-start">
            <span class="d-flex flex-row gap-2">
                <label for="homme">Homme:</label>
                <input type="radio" name="genre" id="homme" value="H" class="form-check">
            </span>
            <span class="d-flex flex-row gap-2">
                <label for="femme">Femme:</label>
                <input type="radio" name="genre" id="femme" value="F" class="form-check">
            </span>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
