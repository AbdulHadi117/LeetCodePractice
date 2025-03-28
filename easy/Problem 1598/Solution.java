class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs){
            if (log.equals("../")){
                level = Math.max(0,level-1);
            }else if (!log.equals("./")){
                level += 1;
            }
        }
        return level;
    }
}