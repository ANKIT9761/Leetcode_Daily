// link- https://leetcode.com/problems/sort-characters-by-frequency/description/

class Solution {
        public String frequencySort(String s) {
        Map<Character, Integer> store = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            store.put(s.charAt(i), store.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        List<Map.Entry<Character, Integer> > list
            = new LinkedList<Map.Entry<Character, Integer> >(
                store.entrySet());
        
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<Character, Integer> e : list){
            int i = e.getValue();
            while(i > 0){
                sb.append(e.getKey());
                i--;
            }
        }
        return sb.toString();
    }
}
