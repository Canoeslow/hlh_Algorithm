/**
    * @author 韩橹航
    * @version 1.0
    * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
    *
    * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
    *
    * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
    *
    * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
*/
//
package 文本左右对齐;

import java.util.ArrayList;
import java.util.List;

//这道题目的核心就是一个贪心算法，通过在循环之中确定每行能够出现最多的单词数量
//在进行判断是那行进行对应的规则进行匹配
public class first {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<String>();
        int right=0,n=words.length;
        while(true){
            //当前行的第一个单词在words的位置
            int left=right;
            //统计这一行单词长度之和
            int sumLen=0;
            //通过循环确定当前行可以放多少个单词，单词之间至少应该有一个空格
            while(right<n&&sumLen+words[right].length()+right-left<=maxWidth){
                sumLen+=words[right++].length();
            }
            //如果当前行是最后一行，单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if(right==n){
                StringBuffer sb=join(words,left,n," ");
                sb.append(blank(maxWidth-sb.length()));
                ans.add(sb.toString());
                return ans;
            }
            int numWords=right-left;
            int numSpaces=maxWidth-sumLen;
            //当前行只有一个单词的时候，该单词左对齐，在行末填充剩余空格
            if(numWords==1){
                StringBuffer sb=new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }
            //当前行不只是一个单词
            int avgSpaces=numSpaces/(numWords-1);
            int extraSpaces=numSpaces%(numWords-1);
            StringBuffer sb=new StringBuffer();
            sb.append(join(words,left,left+extraSpaces+1,blank(avgSpaces+1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words,left+extraSpaces+1,right,blank(avgSpaces)));
            ans.add(sb.toString());
        }
    }
    //返回长度为n的由空格组成的字符串
    public String blank(int n){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append(' ');
        }
        return sb.toString();
    }
    //join返回left到right范围内的words组成的字符串
    public StringBuffer join(String[] words,int left,int right,String sep){
        StringBuffer sb=new StringBuffer(words[left]);
        for(int i=left+1;i<right;i++){
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}
