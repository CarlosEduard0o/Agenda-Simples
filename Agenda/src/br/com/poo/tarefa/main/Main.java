package br.com.poo.tarefa.main;

import br.com.poo.tarefa.agenda.Agenda;
import br.com.poo.tarefa.contato.Contato;
import br.com.poo.tarefa.interfaceusuario.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        ui.mostrarNaTela("Digite o nome do proprietário: ");
        String nomeProprietario = ui.lerDados().next();
        ui.mostrarNaTela(("Entre com a quantidade máxima de contatos: "));
        int qtdeContatos = ui.lerDados().nextInt();
        Agenda agenda = new Agenda(nomeProprietario, qtdeContatos);
        int opcao = -1;
        do{
            ui.mostrarNaTela("" +
                    "\nSistema Agenda do " + agenda.getProprietario() +
                    "\n=== Opções ===" +
                    "\n1. Adicionar Contato" +
                    "\n2. Listar todos os Contatos" +
                    "\n3. Buscar Contato por posição" +
                    "\n4. Consultar Quantidade de Contatos" +
                    "\n0. Sair do Sistema");
            opcao = ui.lerDados().nextInt();
            switch (opcao){
                case 1:
                    ui.mostrarNaTela("Nome: ");
                    String nomeContato = ui.lerDados().next();
                    ui.mostrarNaTela("E-mail: ");
                    String emailContato = ui.lerDados().next();
                    ui.mostrarNaTela("Telefone Principal: ");
                    String telefonePrincipalContato = ui.lerDados().next();
                    ui.mostrarNaTela("Telefone Secundàrio: ");
                    String telefoneSecundarioContato = ui.lerDados().next();
                    Contato contato = new Contato(nomeContato, emailContato, telefonePrincipalContato, telefoneSecundarioContato);
                    agenda.adicionarContato(contato);
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    ui.mostrarNaTela("Índice do contato");
                    int indiceContato = ui.lerDados().nextInt();
                    agenda.mostrarNaTelaPorIndice(agenda.buscarPorPosicao(indiceContato));
                    break;
                case 4:
                    ui.mostrarNaTela("Total de Contatos: " + agenda.listarQuantidadeContatos());
                    break;
                case 0:
                    ui.mostrarNaTela("Saindo..");
                    break;
                default: ui.mostrarNaTela("Opção Inválida");
            }
        } while (opcao != 0);
    }
}