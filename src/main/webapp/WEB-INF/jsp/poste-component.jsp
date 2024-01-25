<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Poste: </span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/poste">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="designation">Designation:</label>
            <input class="form-select" id="designation" name="designation" type="text" placeholder="Designation">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="salaire">Salaire de base:</label>
            <input type="number" min="0" name="salaire" id="salaire" class="form-control" value="0"/>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
