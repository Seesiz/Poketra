<%@ page import="com.project.project.Model.Employe" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.project.Model.Sac" %>
<% List<Sac> all = (List<Sac>) request.getAttribute("sacs"); %>

<div class="card col-12 p-0">
    <header>
        <span style="font-size: 30px">Gestion de duree:</span>
    </header>
    <form class="row d-flex justify-content-between p-4" id="myForm">
        <span class="col-12 d-flex flex-column align-items-start">
            <label for="sac">Sac:</label>
            <select name="idsac" id="sac" class="form-control">
                <% for(Sac e : all){ %>
                    <option value="<%=e.getSacId()%>"><%=e.getSacNom()%></option>
                <% } %>
            </select>
        </span>
        <span class="d-flex gap-2">
            <input type="text" name="designation_Employe">
            <input type="number" name="quantite_Employe">
            <input type="number" name="duree_Employe">
            <input type="number" name="salaire_Employe">
        </span>
        <button class="btn btn-primary mt-2">Valider</button>
    </form>
</div>
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
                alert("SUCCESS");
            },
            error: function(response){
                alert("ERROR");
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