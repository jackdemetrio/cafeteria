// Classe Node representa um nó em uma lista simplesmente ligada
public class Node {
    int id; // ID do pedido
    String description; // Descrição do pedido
    Node next; // Próximo nó na lista

    // Construtor do nó
    public Node(int id, String description) {
        this.id = id;
        this.description = description;
        this.next = null;
    }
}
