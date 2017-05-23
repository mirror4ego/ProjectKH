package dao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Tree extends JFrame
{
	JDialog test;
	JTree tree;
	DefaultMutableTreeNode rootNode;
	JScrollPane pane;
	JPanel panel;
	JButton remove;
	JButton insert;


	Tree()
	{
		test = new JDialog(this, "tree", true);
		rootNode=createNodes();
		tree=new JTree(rootNode);
		pane=new JScrollPane();
		pane.setViewportView(tree);
		
		remove=new JButton("Remove");
		insert=new JButton("insert");

		panel = new JPanel();

	}

	public DefaultMutableTreeNode createNodes()
	{
      DefaultMutableTreeNode rootNode=new DefaultMutableTreeNode("OnLine");
      rootNode.add(new DefaultMutableTreeNode("Java"));
      rootNode.add(new DefaultMutableTreeNode("C++"));
      rootNode.add(new DefaultMutableTreeNode("Oracle"));

	  return rootNode;
	}
	
	public void makeGUI()
	{
		remove.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae2){
	  removeSelectedNode();
	  }
	 });

	 insert.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
	 addTextFieldValue();
	}
	 });

	
	test.setSize(600, 400);
	panel.setSize(500, 300);
	pane.setSize(500, 300);
//	pane.setLocation(10, 10);
	panel.add(pane);
	
	panel.setVisible(true);
	test.add(panel,"Center");
//	test.add(panel);

	insert.setSize(60,20);
//	insert.setLocation(10, 300);
//	test.add(insert);
	test.add(insert,"North");
	insert.setVisible(true);

	remove.setSize(60,20);
//	remove.setLocation(100, 300);
//	test.add(remove);
	test.add(remove,"South");
	remove.setVisible(true);

	//pane.setVisible(true);
	
	test.setVisible(true);
	
	}

	public void addTextFieldValue()
	{
	  DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("나");
	  TreePath selectionPath=tree.getSelectionPath();
	  DefaultMutableTreeNode selectedNode=
	         (DefaultMutableTreeNode)selectionPath.getLastPathComponent();
	 ((DefaultTreeModel)tree.getModel())
	       .insertNodeInto(newNode,selectedNode,selectedNode.getChildCount());
	}

	public void removeSelectedNode()
	{
		 TreePath selectionPath=tree.getSelectionPath();
		 DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)selectionPath.getLastPathComponent();
		
		((DefaultTreeModel)tree.getModel()).removeNodeFromParent(selectedNode);

	}

	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.makeGUI();
	}
}

