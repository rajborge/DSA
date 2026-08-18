class Solution {
    public void backtrack(String digits,int index,StringBuilder sb,List<String> ans,Map<Character,String> digitToLetters){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }

        String letters=digitToLetters.get(digits.charAt(index));
        for(char letter:letters.toCharArray()){
            sb.append(letter);
            backtrack(digits,index+1,sb,ans,digitToLetters);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();

        if(digits==null || digits.length()==0) return ans;

        Map<Character,String> digitToLetters=new HashMap<>();
        digitToLetters.put('2',"abc");
        digitToLetters.put('3',"def");
        digitToLetters.put('4',"ghi");
        digitToLetters.put('5',"jkl");
        digitToLetters.put('6',"mno");
        digitToLetters.put('7',"pqrs");
        digitToLetters.put('8',"tuv");
        digitToLetters.put('9',"wxyz");

        backtrack(digits,0,new StringBuilder(),ans,digitToLetters);

        return ans;
    }
}