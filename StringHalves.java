// link- https://leetcode.com/problems/determine-if-string-halves-are-alike/description/

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] st = s.toLowerCase().toCharArray();
        int left = 0;
        int right = st.length-1;
        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(vowels));
        int leftCount = 0;
        int rightCount = 0;

        while(left < right){
            if(set.contains(st[left])){
                leftCount += 1;
            }
            if(set.contains(st[right])){
                rightCount += 1;
            }
            left ++;
            right --;

        }
        return leftCount == rightCount;
    }
}
