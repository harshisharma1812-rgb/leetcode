public class Codec {

    public String serialize(TreeNode root) {

        if (root == null) return "null";

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }

    public TreeNode deserialize(String data) {

        Queue<String> queue =
            new LinkedList<>(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}