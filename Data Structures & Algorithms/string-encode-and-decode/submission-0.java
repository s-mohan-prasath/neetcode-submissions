class Solution {

    public String encode(List<String> strs) {
        StringBuilder out = new StringBuilder();
        for(String str:strs){
            out.append(str.length());
            out.append("#");
            out.append(str);
        }
        return out.toString();
    }

    public List<String> decode(String str) {
        int len = str.length();
        int i = 0,j,l;
        List<String> out = new ArrayList<>();
        while(i<len){
            j = i;
            while(str.charAt(j)!='#')j++;
            l = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+l;
            out.add(str.substring(i,j));
            i = j;
        }
        return out;
    }
}
