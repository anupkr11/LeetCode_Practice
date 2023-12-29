class Solution {

    public static int bs(int[] potions,int spell, long success){
        int l=0;
        int r=potions.length-1;

        while(l<=r){
            int m = l - (l-r)/2;
            long mul =(long) potions[m]*spell;
            if(mul>=success){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return potions.length-l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int res[] = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            res[i] = bs(potions,spells[i],success);
        }

        return res;
    }
}