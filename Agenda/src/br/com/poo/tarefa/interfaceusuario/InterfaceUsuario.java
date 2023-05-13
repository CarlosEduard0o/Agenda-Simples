package br.com.poo.tarefa.interfaceusuario;

import br.com.poo.tarefa.contato.Contato;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner ler;

    public InterfaceUsuario() {
        this.ler = new Scanner(System.in);
    }
    public Scanner lerDados(){
        return this.ler;
    }
    public void mostrarNaTela(String mensagem){
        System.out.println(mensagem);
    }
}
