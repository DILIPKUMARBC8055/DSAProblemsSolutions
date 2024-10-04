class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int start=0;
        int end=skill.length-1;
        int teamSkill=skill[start]+skill[end];
        long chemistry=0;
        while(start<end)
        {
            if(teamSkill == skill[start]+skill[end] )
            {
                chemistry+=(long) skill[start]*skill[end];
            }else 
            {
                return -1;
            }
            start++;
            end--;
        }
        return chemistry;
    }
}