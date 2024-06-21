public class BinaryTree {
    // Declare root node
    Node root;

    // Recursively inserts new nodes in `BinaryTree`
    public void insertNode(String state, String capital) {
        // Instantiate new node with method parameters
        Node newNode = new Node(state, capital);

        // Assigns `newNode` to `root` if `newNode` is the first node
        if (root == null) {
            root = newNode;
        // `else` block executes if `newNode` is not the first node
        } else {
            Node focusNode = root;
            Node parentNode;

            /* Infinite loop recursively calls itself until node has been
                assigned to a parent node
             */
            while (true) {
                parentNode = focusNode;

                /* If the new Node is less than the focus node, the `leftChild`
                   node becomes the new focus node
                 */
                if (state.compareTo(focusNode.state) < 1) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                /* If the new Node is greater than the focus node, the
                `rightChild` node becomes the new focus node
                 */
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Search the Binary Search Tree using the `state` as the key
    Node searchNode(String state) {
        Node focusNode = root;

        /* Create recursive `while` loop to alphabetically compare the `state`
           key to the `state` data of the focus node
         */
        while (!focusNode.state.equals(state)) {
            /* If the `state` key is less than the focus node `state` data,
               the `leftChild` node becomes the new focus node
             */
            if (state.compareTo(focusNode.state) < 1) {
                focusNode = focusNode.leftChild;
            /* If the `state` key is greater than the focus node `state` data,
               the `rightChild` node becomes the new focus node
             */
            } else {
                focusNode = focusNode.rightChild;
            }

            // Return `null` if the `state` key was not found
            if (focusNode == null) {
                return null;
            }
        }
        /* Return the focus node if the `state` key was found in the focus node
           `state` data
         */
        return focusNode;
    }
}

class Node {
    String state;
    String capital;

    Node leftChild;
    Node rightChild;

    // Constructor
    Node(String state, String capital) {
        this.state = state;
        this.capital = capital;
    }
}
