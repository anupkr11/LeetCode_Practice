class Solution {
    class Score implements Comparable<Score>
    {
        Integer value;
        Score(Integer val)
        {
            value=val;
        }
        public int compareTo(Score o) 
        {
        return o.value.compareTo(this.value);
        }
    }
    public String[] findRelativeRanks(int[] score) 
    {
        String res[]=new String[score.length];
      ArrayList<Score> al=new ArrayList<>();
        for(int i=0;i<score.length;i++)
        {
            al.add(new Score(score[i]));
        }
        ArrayList<Score> al1=new ArrayList<>(al);
        Collections.sort(al);
        for(int i=0;i<al.size();i++)
        {
            int pos=al.indexOf(al1.get(i));
            if(pos==0)
                res[i]="Gold Medal";
            else if(pos==1)
                res[i]="Silver Medal";
            else if(pos==2)
                res[i]="Bronze Medal";
            else
                res[i]=pos+1+"";
        }
        return res;
    }
}