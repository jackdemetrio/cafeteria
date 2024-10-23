import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack canceledOrders = new Stack();
        Queue pendingOrders = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice, id;
        String description;

        do {
            // Exibe o menu de opções
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (choice) {
                case 1:
                    System.out.print("ID do Pedido: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha
                    System.out.print("Descrição do Pedido: ");
                    description = scanner.nextLine();
                    pendingOrders.enqueue(id, description);
                    System.out.println("Pedido adicionado.");
                    break;
                case 2:
                    Node servedOrder = pendingOrders.dequeue();
                    if (servedOrder != null) {
                        System.out.println("Pedido Atendido: ID " + servedOrder.id + ", Descrição: " + servedOrder.description);
                    }
                    break;
                case 3:
                    Node canceledOrder = pendingOrders.dequeue();
                    if (canceledOrder != null) {
                        canceledOrders.push(canceledOrder.id, canceledOrder.description);
                        System.out.println("Pedido Cancelado: ID " + canceledOrder.id + ", Descrição: " + canceledOrder.description);
                    }
                    break;
                case 4:
                    Node restoredOrder = canceledOrders.pop();
                    if (restoredOrder != null) {
                        pendingOrders.enqueue(restoredOrder.id, restoredOrder.description);
                        System.out.println("Pedido Restaurado: ID " + restoredOrder.id + ", Descrição: " + restoredOrder.description);
                    }
                    break;
                case 5:
                    System.out.println("Pedidos Pendentes:");
                    pendingOrders.printQueue();
                    break;
                case 6:
                    System.out.println("Pedidos Cancelados:");
                    canceledOrders.printStack();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
