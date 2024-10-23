// Classe Stack para implementar a Pilha de Pedidos Cancelados
public class Stack {
    Node top; // Topo da pilha

    // Método para adicionar um pedido cancelado ao topo da pilha
    public void push(int id, String description) {
        Node newNode = new Node(id, description);
        newNode.next = top;
        top = newNode;
    }

    // Método para remover o pedido cancelado mais recente da pilha
    public Node pop() {
        if (top == null) {
            System.out.println("Pilha vazia.");
            return null;
        }
        Node temp = top;
        top = top.next;
        return temp;
    }

    // Método para imprimir todos os pedidos cancelados na pilha
    public void printStack() {
        Node current = top;
        if (current == null) {
            System.out.println("Pilha vazia.");
            return;
        }
        while (current != null) {
            System.out.println("ID: " + current.id + ", Descrição: " + current.description);
            current = current.next;
        }
    }
}
