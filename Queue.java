// Classe Queue para implementar a Fila de Pedidos Pendentes
public class Queue {
    Node front, rear; // Início e fim da fila

    // Método para adicionar um pedido ao final da fila
    public void enqueue(int id, String description) {
        Node newNode = new Node(id, description);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Método para remover o pedido mais antigo da fila
    public Node dequeue() {
        if (front == null) {
            System.out.println ("Fila vazia.");
            return null;
        }
        Node temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    // Método para imprimir todos os pedidos pendentes na fila
    public void printQueue() {
        Node current = front;
        if (current == null) {
            System.out.println("Fila vazia.");
            return;
        }
        while (current != null) {
            System.out.println("ID: " + current.id + ", Descrição: " + current.description);
            current = current.next;
        }
    }
}
