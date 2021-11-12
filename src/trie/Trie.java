package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Trie {
    int ALPHABET_SIZE = 26;
    List<Trie> children;
    boolean isWordEnd;

    Trie() {
        isWordEnd = false;
        children = new ArrayList<>(Collections.nCopies(ALPHABET_SIZE, null));
    }
    Trie(boolean status){
        isWordEnd = status;
        children = new ArrayList<>(Collections.nCopies(ALPHABET_SIZE, null));
    }

    void insert(String s) {
        Trie current = this;
        s=s.toUpperCase(Locale.ROOT);
        for (int i = 0; i < s.length(); i++) {
            if (current.children.get(s.charAt(i) - 'A') == null) {
                if(i==s.length()-1)
                    current.children.set(s.charAt(i) - 'A', new Trie(true));
                else
                    current.children.set(s.charAt(i) - 'A', new Trie());
                current=current.children.get(s.charAt(i) - 'A');
            }
            else{
                current=current.children.get(s.charAt(i) - 'A');
                if(i==s.length()-1)
                    current.isWordEnd=true;
            }


        }
    }
    boolean search(String s) {
        s=s.toUpperCase(Locale.ROOT);
        Trie current = this;
        for (int i = 0; i < s.length(); i++) {
            if (current.children.get(s.charAt(i) - 'A') == null) {
                return false;
            } else {
                if (i == s.length() - 1) {
                    if (current.children.get(s.charAt(i) - 'A').isWordEnd) {
                        return true;
                    }
                }
            }
            current = current.children.get(s.charAt(i) - 'A');

        }
        return false;
    }

    ArrayList<ArrayList<String>> returnMatching(String s){
        s=s.toUpperCase(Locale.ROOT);
        ArrayList<ArrayList<String>> out=new ArrayList<>();
        ArrayList<String> result;
        boolean canRun;
        for(int i=1;i<=s.length();i++){
            canRun=true;
            String sdet= s.substring(0,i);
            result= new ArrayList();
            Trie current=this;
            for (int j = 0; j < sdet.length(); j++) {
                    if(current.children.get(sdet.charAt(j)-'A')!=null)
                    current=current.children.get(sdet.charAt(j)-'A');
                    else{
                        canRun=false;
                        result.add("0");
                        break;
                    }
            }
            if(canRun)
                returnAllHelper(sdet,current,result);
                out.add(result);
        }
        return out;
    }
    String returnMatchingPrefix(String s){
        s=s.toUpperCase(Locale.ROOT);
        ArrayList<String> result=null;
        boolean canRun;
        for(int i=1;i<=s.length();i++){
            canRun=true;
            String sdet= s.substring(0,i);
            result= new ArrayList();
            Trie current=this;
            for (int j = 0; j < sdet.length(); j++) {
                if(current.children.get(sdet.charAt(j)-'A')!=null)
                    current=current.children.get(sdet.charAt(j)-'A');
                else{
                    canRun=false;
                    result.add("0");
                    break;
                }
            }
            if(canRun)
                returnAllHelper(sdet,current,result);
            if(result.size()==1)
                return sdet;
        }
        return "NOT FOUND";

    }


    ArrayList<String> returnAll(){
        ArrayList<String> result= new ArrayList();
        returnAllHelper("",this,result);
        return result;
    }
    private void returnAllHelper(String result,Trie node,ArrayList<String> resultSet){
        if(node.isWordEnd)
             resultSet.add(result);
            for (int i = 0; i < node.children.size(); i++)
                if(node.children.get(i)!=null)
                    returnAllHelper(result.concat(String.valueOf((char) (i + 65))),node.children.get(i),resultSet);
    }
}
