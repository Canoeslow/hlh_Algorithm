/**
 * @Author hanluhang
 * @Date 2021/7/16 16:03
 * 广度优先遍历输出树中的数据
 */
package 广度优先遍历输出数据_树;

import java.util.*;

public class first {
    public static void bfs(Map<Character, List<Character>> index,char start){
        // 广度优先遍历树
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited=new HashSet<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            char node=queue.poll();
            System.out.println("访问的节点是:"+node);
            for(char neighor:index.get(node)){
                if(!visited.contains(neighor)){
                    queue.add(neighor);
                    visited.add(neighor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> idnex = new HashMap<>();
        idnex.put('A', Arrays.asList('B', 'C'));
        idnex.put('B', Arrays.asList('A', 'D', 'E'));
        idnex.put('C', Arrays.asList('A', 'F'));
        idnex.put('D', Arrays.asList('B'));
        idnex.put('E', Arrays.asList('B'));
        idnex.put('F', Arrays.asList('C'));

        bfs(idnex, 'A');
    }
}
