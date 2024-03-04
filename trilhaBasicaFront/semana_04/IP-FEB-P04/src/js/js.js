function capturarInformacoes(event) {
    
    const button = event.target;
    const roteiroViagem = button.parentElement;
    const destino = roteiroViagem.querySelector('.roteiro-destino').innerText;
    const inclusos = Array.from(roteiroViagem.querySelectorAll('.roteiro-incluso li')).map(item => item.innerText);
    const preco = roteiroViagem.querySelector('.roteiro-preco').innerText;
    const observacoes = roteiroViagem.querySelector('.roteiro-obs').innerText;
    const parcelamento = roteiroViagem.querySelector('.roteiro-parcelamento').innerText;

    const pacoteTuristico = {
      destino: destino,
      inclusos: inclusos,
      preco: preco,
      observacoes: observacoes,
      parcelamento: parcelamento
    };

    console.log(JSON.stringify(pacoteTuristico));
}
