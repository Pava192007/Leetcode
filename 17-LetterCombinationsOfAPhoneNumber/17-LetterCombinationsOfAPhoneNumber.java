// Last updated: 7/17/2026, 9:11:00 AM
class Solution {
    String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;
        backTrack(0,digits,ans,new StringBuilder());
        return ans;
    }
    public void backTrack(int ind, String digits, List<String> ans, StringBuilder sb){
        if(ind == digits.length()){

            ans.add(sb.toString());
            return;
        }
        String getDigitString = keypad[digits.charAt(ind) - '0'];
        for(int i = 0; i<getDigitString.length(); i++){
            sb.append(getDigitString.charAt(i));
            backTrack(ind +1,digits,ans,sb);
            sb.deleteCharAt(sb.length() -1);
        }

    }
}