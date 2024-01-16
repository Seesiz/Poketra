<div class="side-bar col-2 p-0" style="height: 100vh; overflow-y: auto">
    <header class="p-2">
        <span class="d-flex align-items-center gap-2" style="font-size: 30px; color: white"><i style="font-size: 25px" class="fa-brands fa-shoelace"></i> Poketra...</span>
    </header>
    <section style="padding: 4% !important; padding-right: 0% !important;">
        <div class="accordion accordion-flush" id="accordionFlushExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <span class="accordion-button collapsed" id="adminbtn" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        Admin
                    </span>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <ul class="menu d-flex flex-column gap-2 p-0">
                        <a href="/main/?title=Unite&page=unite"><li id="unite" class="adminbtn"><i class="fa fa-swatchbook"></i> Unite</li></a>
                        <a href="/main/?title=Look&page=look"><li id="look" class="adminbtn"><i class="fa fa-pen-nib"></i> Look</li></a>
                        <a href="/prixMatiere"><li id="prixMatiere" class="adminbtn"><i class="fa fa-money-bill"></i> Prix</li></a>
                        <a href="/main/?title=Matiere&page=matiere"><li id="matiere" class="adminbtn"><i class="fa-brands fa-elementor"></i> Matiere</li></a>
                        <a href="/quantite"><li id="quantite" class="adminbtn"><i class="fa-solid fa-hashtag"></i>Quantite</li></a>
                        <a href="/employe"><li id="employe" class="adminbtn"><i class="fa fa-box"></i>Employe</li></a>
                        <a href="/creation"><li id="creation" class="adminbtn"><i class="fa fa-tape"></i>Creation</li></a>
                        <a href="/stockMatiere"><li id="stock" class="adminbtn"><i class="fa fa-box"></i>Stock</li></a>
                        <a href="/fabrication"><li id="fabrication" class="adminbtn"><i class="fa fa-industry"></i>Fabrication</li></a>
                    </ul>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <span class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        Accordion Item #2
                    </span>
                </h2>
                <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being filled with some actual content.</div>
                </div>
            </div>
        </div>
    </section>
</div>
<script>
    var pageElement = document.getElementById('${page}');
    var classesList = pageElement.classList;
    classesList.add('active');
    var parentId = '#' + classesList[0];
    $(parentId).attr('aria-expanded', 'true');
    $(parentId).removeClass("collapsed");
    pageElement.parentElement.parentElement.parentElement.classList.add("show");
</script>