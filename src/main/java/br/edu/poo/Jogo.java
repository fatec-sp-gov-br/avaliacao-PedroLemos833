package br.edu.poo;

public class Jogo {
    public static void main(String[] args) {
        // Criando os personagens conforme o exemplo do enunciado
        Personagem artemis = new Personagem("Artemis", 30, 12, 4);
        Personagem goblin = new Personagem("Goblin", 20, 8, 2);

        // Criando uma poção
        Pocao pequena = new Pocao("Poção Pequena", 10);

        System.out.println("=== BATALHA INICIADA ===\n");

        // Loop da batalha por turnos
        while (artemis.estaVivo() && goblin.estaVivo()) {
            
            // Turno da Artemis
            artemis.atacar(goblin);
            if (!goblin.estaVivo()) break;

            // Turno do Goblin
            goblin.atacar(artemis);
            if (!artemis.estaVivo()) break;

            // Exemplo de uso de poção pelo Goblin se a vida estiver baixa
            if (goblin.getVida() <= 5 && goblin.estaVivo()) {
                goblin.usarPocao(pequena);
            }
        }

        System.out.println("=== FIM DA BATALHA ===");
        
        // Verificando o vencedor
        if (artemis.estaVivo()) {
            System.out.println("Vencedor: " + artemis.getNome());
        } else {
            System.out.println("Vencedor: " + goblin.getNome());
        }
    }
}
