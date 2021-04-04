package tc.wo.jeonghan.week5.assignment;

import java.util.LinkedList;

public class BinaryTree {
	
	public static void bfs(Node node) {
		LinkedList<Node> nodeList = new LinkedList<>();
		nodeList.addLast(node);
		
		while (!nodeList.isEmpty()) {
			Node targetNode = nodeList.getFirst();
			nodeList.removeFirst();
			
			if (targetNode.getLeft() != null) {
				nodeList.addLast(targetNode.getLeft());
			}
			
			if (targetNode.getRight() != null) {
				nodeList.addLast(targetNode.getRight());
			}
			
			System.out.println("Node value : " + targetNode.getValue());
		}
	}
	
	public static void dfs(Node node) {
		Node left = node.getLeft();
		if (left!=null) {
			dfs(left);
		}
		
		System.out.println("Node value : " + node.getValue());
		
		Node right = node.getRight();
		if (right!=null) {
			dfs(right);
		}
	}
}
