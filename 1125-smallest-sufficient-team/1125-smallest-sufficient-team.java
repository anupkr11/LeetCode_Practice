class Solution {
    private Map<String, Integer> map;
    private Long[] dp;
    private int skillsMaskOfPerson[];
    private int targetMask;
    private int n;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length;
        n = people.size();
        map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(req_skills[i],i);
        }
        skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << map.get(skill);
            }
        }
        targetMask = (1 << m) - 1;
        dp = new Long[1 << m];
        long answerMask = solve(0);
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }

    public long solve(int skillMask){
        if(skillMask == targetMask) return 0;
        if(dp[skillMask] != null) return dp[skillMask];
        for(int i = 0; i < n; i++){
            int totalSkillAcquiredMask = skillMask | skillsMaskOfPerson[i];
            // condition := so that it doesn't get stuck in infinite loop(Stack overflow)
            if(totalSkillAcquiredMask != skillMask){
                long peopleMask = solve(totalSkillAcquiredMask) | (1l << i);
                if(dp[skillMask] == null || Long.bitCount(peopleMask) < Long.bitCount(dp[skillMask])){
                    dp[skillMask] = peopleMask;
                }
            }
        }
        return dp[skillMask];
    }
}