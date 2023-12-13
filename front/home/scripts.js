// Implementação do carrossel simples
let slideIndex = 0;

function carousel() {

    let i;
    const slides = document.getElementsByClassName("carousel-item");
    console.log("Carrossel rodando", slides, slideIndex)

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1;
    }
    slides[slideIndex - 1].style.display = "block";
    setTimeout(carousel, 2000); // Troca a cada 2 segundos
}
