/**
 * @Author hanluhang
 * @Date 2021/7/15 14:52
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 */
package 客隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class first {
    public Node cloneGraph(Node node) {
        //通过一个Map记录已经访问过的节点
        Map<Node,Node> index=new HashMap<>();
        return dfs(node,index);
    }
    private Node dfs(Node node,Map<Node,Node> index){
        if(node==null) return null;
        if(index.containsKey(node)) return index.get(node);
        Node clone=new Node(node.val,new ArrayList<>());
        index.put(node,clone);
        for(Node n:node.neighbors) clone.neighbors.add(dfs(n,index));
        return clone;
    }
}
