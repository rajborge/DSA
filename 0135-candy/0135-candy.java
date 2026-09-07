class Solution {
    public int candy(int[] ratings) {
        int sum=1;
        int index=1;

        while(index<ratings.length){
            if(ratings[index]==ratings[index-1]){
                sum++;
                index++;
            }
            int peak=1;
            while(index<ratings.length && ratings[index]>ratings[index-1]){
                peak++;
                sum+=peak;
                index++;
            }
            int down=1;
            while(index<ratings.length && ratings[index]<ratings[index-1]){
                sum+=down;
                down++;
                index++;
            }
            if(down>peak) sum+=(down-peak);
        }
        return sum;
    }
}