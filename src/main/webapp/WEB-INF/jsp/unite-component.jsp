<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout d'unite:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="myForm">
        <span class="col-12 d-flex flex-column align-items-start">
            <label for="name">Nom:</label>
            <input type="text" name="uni_nom" id="name" class="form-control" placeholder="Nom">
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<jsp:include page="taille-component.jsp"></jsp:include>
<script>
    function sendData(event){
        var formDataArray = $("#myForm").serializeArray();
        var formData = new FormData();
        $.each(formDataArray, function(index, field){
            formData.append(field.name, field.value);
        });

        $.ajax({
            type: 'POST',
            url: '/unite',
            data: formData,
            contentType: false,
            processData: false,
            success: function(response){
                console.log(response);
            },
            error: function(response){
                console.log(response);
            }
        })
    }

    $(document).ready(function(){
        $("#myForm").submit(function(event){
            event.preventDefault();
            sendData(event);
        })
    })
</script>