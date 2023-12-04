document.addEventListener('DOMContentLoaded', function () {
    function inserirPacote() {
        const destino = document.getElementById('destino').value;
        const imagem = document.getElementById('imagem').value;
        const inclusos = document.getElementById('inclusos').value.split('\n');
        const preco = document.getElementById('preco').value;
        const obs = document.getElementById('obs').value;
        const parcelamento = document.getElementById('parcelamento').value.split('\n');

        const novoPacote = document.createElement('div');
        novoPacote.className = 'roteiro-viagens';

        novoPacote.innerHTML = `
        <div class="roteiros-viagens">
            <img src="${imagem}" class="postal">
            <div class="roteiro-destino">${destino}</div>
            <ul class="roteiro-incluso">
                ${inclusos.map(item => `<li>${item}</li>`).join('')}
            </ul>
            <div class="roteiro-preco">R$${preco}</div>
            <div class="roteiro-obs">${obs}</div>
            <div class="roteiro-parcelamento">${parcelamento.join('<br>')}</div>
            <button class="roteiro-comprar">Comprar</button>
        </div>
        `;

        const containerDestinos = document.getElementById('container-destinos');
        containerDestinos.appendChild(novoPacote);
    }
    const botaoInserir = document.querySelector('button');
    botaoInserir.addEventListener('click', inserirPacote);
})