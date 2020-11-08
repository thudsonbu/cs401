public class node {

    node left;
    node right;
    int value;

    public node(node leftLink, node rightLink, int val) {

        this.left = leftLink;
        this.right = rightLink;
        this.value = val;
    }
}
