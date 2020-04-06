package Programmers;

import java.util.*;

public class FindRouteGame {

    public static void main(String[] args) {
        int[][] data = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answer = solution(data);
        for (int[] i : answer) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static int idx;

    public static int[][] solution(int[][] nodeinfo) {
        List<Nodes> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Nodes(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        Collections.sort(nodes, new Comparator<Nodes>() {
            @Override
            public int compare(Nodes o1, Nodes o2) {
                if (o1.y != o2.y) {
                    return o2.y - o1.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });
        Nodes root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            addNode(root, nodes.get(i));
        }
        int[][] answer = new int[2][nodes.size()];
        preOrder(root, answer);
        idx = 0;
        postOrder(root, answer);
        return answer;
    }

    static void preOrder(Nodes root, int[][] answer) { // 전위순회
        if (root != null) {
            answer[0][idx++] = root.index;
            preOrder(root.left, answer);
            preOrder(root.right, answer);
        }
    }

    static void postOrder(Nodes root, int[][] answer) { // 후위순회
        if (root != null) {
            postOrder(root.left, answer);
            postOrder(root.right, answer);
            answer[1][idx++] = root.index;
        }
    }

    static void addNode(Nodes parent, Nodes child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }
}

class Nodes {

    int x;
    int y;
    int index;
    Nodes left;
    Nodes right;

    public Nodes(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}
