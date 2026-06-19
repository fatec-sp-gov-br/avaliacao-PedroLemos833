package br.edu.poo;

public class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean pocaoUtilizada; // Inicia como false por padrão

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocaoUtilizada = false;
    }

    public void atacar(Personagem inimigo) {
        // Regra 1: dano = ataque - defesa
        int dano = this.ataque - inimigo.defesa;

        // Regra 2: Todo ataque deve causar pelo menos 1 ponto de dano
        if (dano < 1) {
            dano = 1;
        }

        System.out.println(this.nome + " ataca " + inimigo.getNome());
        inimigo.receberDano(dano);
    }

    public void receberDano(int dano) {
        this.vida -= dano;

        // Regra 3: A vida nunca pode ficar negativa
        if (this.vida < 0) {
            this.vida = 0;
        }
        
        System.out.println(this.nome + " possui " + this.vida + " de vida\n");
    }

    public void usarPocao(Pocao pocao) {
        // Regra 5: Cada personagem pode usar apenas uma poção
        if (!pocaoUtilizada) {
            this.vida += pocao.getCura();
            this.pocaoUtilizada = true;
            System.out.println(this.nome + " usa " + pocao.getNome());
            System.out.println(this.nome + " possui " + this.vida + " de vida\n");
        } else {
            // Tentativas posteriores são ignoradas
            System.out.println(this.nome + " tentou usar uma poção, mas já usou uma nesta batalha!\n");
        }
    }

    public boolean estaVivo() {
        // Regra 4: Um personagem é derrotado quando vida == 0
        return this.vida > 0;
    }

    // Getters obrigatórios pelos requisitos
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }
}
