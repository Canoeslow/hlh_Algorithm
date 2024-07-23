/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * @Description 简化路径
 * 给你一个字符串 path ，表示一个文件系统中的文件或目录路径。
 *
请你将路径中的连续斜杠（'/'）替换为单个斜杠（'/'）后返回。
在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
请注意，返回的 规范路径 必须遵循下述格式：
始终以斜杠 '/' 开头。
两个目录名之间必须只有一个斜杠 '/' 。
最后一个目录名（如果存在）不能 以 '/' 结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。
 */
package 简化路径_栈;

import java.util.Stack;

//通过栈解决这道问题,首先需要通过字符分解，再通过字符分解进行分析
public class first {
    public String simplifyPath(String path) {
        int n=path.length();
        //首先创建一个栈帧
        Stack<String> stack = new Stack<>();
        //将待匹配的的字符串按照'/'分割
        String[] paths = path.split("/");
        //分割之后按照规则压入栈中
        for (String part : paths) {
            if(part.equals("")||part.equals(".")) continue;
            else if (part.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else {
                //都不属于分割符压入栈帧
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        //将栈帧中的数据拼接成一个字符串
        for (String part : stack) {
            sb.append("/"+part);
        }
        return sb.length()==0?"/":sb.toString();
    }
}
