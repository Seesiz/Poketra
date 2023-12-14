<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de matiere:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="thirdForm" method="POST" action="/matiere">
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="name">Nom:</label>
            <input type="text" name="mat_nom" id="name" class="form-control" placeholder="Nom">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="uniteinput">Unite:</label>
            <select class="form-select" id="uniteinput" name="mat_unite"></select>
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label for="prix">Prix Unitaire:</label>
            <input type="number" class="form-control" id="prix" name="mat_prixunitaire">
        </span>
        <span class="col-6 d-flex flex-column align-items-start">
            <label>Look:</label>
            <ul class="list-group col-12" id="lookList" style="max-height: 20rem; overflow-y: auto">
            </ul>
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<div class="card col-12 p-0">
    <header class="d-flex flex-row justify-content-between align-items-center">
        <span style="font-size: 30px">Liste des matieres:</span>
        <span class="col-2">
            <select class="form-select" id="lookinput">
                <option disabled selected>Choix de look</option>
            </select>
        </span>
    </header>
    <section class="p-2">
        <table class="table">
            <thead>
                <tr>
                    <th>Matiere</th>
                    <th>Prix Unitaire</th>
                    <th>Unite</th>
                </tr>
            </thead>
            <tbody id="tbodydata">

            </tbody>
        </table>
    </section>
</div>
<script>
    $(document).ready(function(){
        $.ajax({
            type: 'GET',
            url: '/unite',
            success: function(response){
                for(let item of response){
                    var newOption = $("<option></option>");
                    newOption.attr('value', item.uniId);
                    newOption.text(item.uni_nom);
                    $("#uniteinput").append(newOption);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
        $.ajax({
            type: 'GET',
            url: '/look',
            success: function(response){
                for(let item of response){
                    var newLook = $("<li></li>");
                    var newCheck = $("<input>");
                    var spanCheck = $("<label></label>");
                    newLook.attr("class", "list-group-item d-flex gap-2 align-items-center");
                    spanCheck.text(item.look_nom);
                    newCheck.attr("value", item.lookId);
                    newCheck.attr("type", "checkbox");
                    newCheck.attr("class", "form-check-input itemlist")
                    newCheck.attr("name", "look");
                    newCheck.attr("id", item.lookId+item.look_nom);
                    spanCheck.attr("for", item.lookId+item.look_nom)
                    newLook.append(newCheck);
                    newLook.append(spanCheck);
                    $("#lookList").append(newLook);
                    var newOption = $("<option></option>");
                    newOption.attr('value', item.lookId);
                    newOption.text(item.look_nom);
                    $("#lookinput").append(newOption);
                }
            },
            error: function(response){
                console.log(response);
            }
        });
        $("#lookinput").change(function(){
            $.ajax({
                type: 'GET',
                url: '/matlook/'+$(this).val(),
                success: function(response){
                    $("#tbodydata").text("");
                    for (let item of response){
                        var tr = $("<tr></tr>");
                        var td1 = $("<td>"+item.matdet_matiere.mat_nom+"</td>");
                        var td2 = $("<td>"+item.matdet_matiere.mat_prixunitaire+"</td>");
                        var td3 = $("<td>"+item.matdet_matiere.mat_unite.uni_nom+"</td>");
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
    })
</script>