package com.newcoder;

public class Offer37 {
	String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
			sb.append("$,");
		}else {
			sb.append(root.val + ",");
			sb.append(Serialize(root.left));
			sb.append(Serialize(root.right));
		}
        return sb.toString();
	}
	int index = 0;
	TreeNode Deserialize(String str) {
		TreeNode root = null;
		if (str == null || str.length() == 0) {
			return root;
		}
		int start = index;
		while(index <= str.length() && str.charAt(index) != ',') {
			index++;
		}
		if (start < str.length() && index <= str.length() && !str.substring(start, index).equals("$")) {
			root = new TreeNode(Integer.parseInt(str.substring(start, index)));
			index++;
			root.left = Deserialize(str);
			root.right = Deserialize(str);
		}else {
			index++;
		}
		return root;
	}
}
