class Solution {
    public void recurse(String current,int open,int close,int n,List<String> result){
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        if(open<n){
            recurse(current + "(",open+1,close,n,result);
        }
        if(close<open){
            recurse(current + ")",open,close+1,n,result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        recurse("",0,0,n,result);
        return result;
    }
}