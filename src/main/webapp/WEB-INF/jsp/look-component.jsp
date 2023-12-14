<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Ajout de look:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="secondForm">
        <span class="col-12 d-flex flex-column align-items-start">
            <label for="name">Nom:</label>
            <input type="text" name="look_nom" id="name" class="form-control" placeholder="Nom">
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
<jsp:include page="type-component.jsp"></jsp:include>
<script>
    function sendData(event){
        var formDataArray = $("#secondForm").serializeArray();
        var formData = new FormData();
        $.each(formDataArray, function(index, field){
            formData.append(field.name, field.value);
        });

        $.ajax({
            type: 'POST',
            url: '/look',
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
        $("#secondForm").submit(function(event){
            event.preventDefault();
            sendData(event);
        })
    })
</script>