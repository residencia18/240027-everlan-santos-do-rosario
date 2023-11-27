class Tarefas {
  constructor(tarefa) {
    this.tarefa = tarefa;
  }
}
if (!localStorage.getItem("tarefas")) {
  localStorage.setItem("tarefas", JSON.stringify([]));
}

function addTarefa() {
  const novaTarefa = document.querySelector("#input").value;
  tarefa = new Tarefas(novaTarefa);
  addTarefasStorage(tarefa);
  document.querySelector("#input").value = "";
  document.querySelector("#input").focus();
}
 function addTarefasStorage(tarefa){
  const tarefas = JSON.parse(localStorage.getItem("tarefas"));
  console.log(tarefas);
  tarefas.push(tarefa);
  console.log("Depois de adicionar: "+tarefas);
  localStorage.setItem("tarefas", JSON.stringify(tarefas));
 }

function listaTarefas() {
  limpar();
  const tarefas = JSON.parse(localStorage.getItem("tarefas"));
  console.log(tarefas);
  const list = document.querySelector("#list");
  tarefas.forEach((tarefa) => {
    const li = document.createElement("li");
    li.innerText = tarefa["tarefa"];
    list.appendChild(li);
  });
}

function limpar() {
  const list = document.querySelector("#list");
  list.innerHTML = "";
}
