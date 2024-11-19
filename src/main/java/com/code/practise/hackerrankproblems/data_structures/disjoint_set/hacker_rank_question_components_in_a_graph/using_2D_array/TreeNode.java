package com.code.practise.hackerrankproblems.data_structures.disjoint_set.hacker_rank_question_components_in_a_graph.using_2D_array;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
