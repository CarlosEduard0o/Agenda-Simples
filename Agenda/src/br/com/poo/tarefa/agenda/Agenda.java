package br.com.poo.tarefa.agenda;

import br.com.poo.tarefa.contato.Contato;
import br.com.poo.tarefa.interfaceusuario.InterfaceUsuario;

public class Agenda {
    private String nome;
    private String email;
    private String proprietario;
    private Contato[] contatos;
    int qtdeContatos;
    InterfaceUsuario ui = new InterfaceUsuario();
    public static int totalContatos;
    public Agenda (String proprietario, int qtdeContatos){
        this.proprietario = proprietario;
        this.contatos = new Contato[qtdeContatos];
        this.qtdeContatos = qtdeContatos;
    }
    public void adicionarContato(Contato contato){
        for(int i = 0; i < contatos.length; i++){
            if(this.contatos[i] == null){
                this.contatos[i] = contato;
                Agenda.totalContatos += 1;
                break;
            }
        }
    }
    public void listarContatos(){
        InterfaceUsuario ui = new InterfaceUsuario();
        boolean contatoVazio = true;
        for (Contato contato : this.contatos){
            if(contato != null){
                ui.mostrarNaTela(contato.obterDados());
                contatoVazio = false;
            }
        }
        if (contatoVazio){
            ui.mostrarNaTela("Não há contatos cadastrados!");
        }
    }

    public Contato buscarPorPosicao(int posicao) {
        if (posicao < qtdeContatos){
            return contatos[posicao];
    } else {
        return null;
        }
    }

    public int listarQuantidadeContatos(){
        return Agenda.totalContatos;
    }

    public String getProprietario(){
        return proprietario;
    }
    public void mostrarNaTelaPorIndice(Contato contatos){
        if (contatos == null){
            System.out.println("Não há nenhum contato cadastrado nesta posição");
        } else {
            System.out.println(contatos.obterDados());
        }
    }
}
