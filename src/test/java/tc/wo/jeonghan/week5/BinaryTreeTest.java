package tc.wo.jeonghan.week5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import tc.wo.jeonghan.week5.assignment.BinaryTree;
import tc.wo.jeonghan.week5.assignment.Node;

public class BinaryTreeTest {
	
	private Node root;
	
	@Before
	public void prepare() {
		List<Node> nodeList = IntStream.range(0, 11)
			.boxed()
			.map(Node::new)
			.collect(Collectors.toList());
		
		root = nodeList.get(0);
		
		root.setLeft(nodeList.get(1));
		nodeList.get(1).setLeft(nodeList.get(3));
		nodeList.get(1).setRight(nodeList.get(4));
		
		root.setRight(nodeList.get(2));
		nodeList.get(2).setLeft(nodeList.get(5));
		nodeList.get(2).setRight(nodeList.get(6));
		
		nodeList.get(6).setRight(nodeList.get(7));
		nodeList.get(7).setLeft(nodeList.get(8));
		
		nodeList.get(8).setLeft(nodeList.get(9));
		nodeList.get(8).setRight(nodeList.get(10));
	}
	
	@Test
	public void dfs() {
		BinaryTree.dfs(root);
	}

	@Test
	public void bfs() {
		BinaryTree.bfs(root);
	}
}
