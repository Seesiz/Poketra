<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de grade: </span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/grade">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="designation">Designation:</label>
            <input class="form-select" id="designation" name="grade" type="text" placeholder="Designation">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="taux">Taux horaire:</label>
            <input type="number" min="0" name="taux" id="taux" class="form-control" value="0"/>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="debut">Min:</label>
            <input type="number" min="0" name="debut" id="debut" class="form-control" value="0"/>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="fin">Max:</label>
            <input type="number" min="0" name="fin" id="fin" class="form-control" value="0"/>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
