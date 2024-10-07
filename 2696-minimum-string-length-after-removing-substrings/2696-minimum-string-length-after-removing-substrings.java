class Solution {
    public int minLength(String s) {
        StringBuilder str = new StringBuilder(s);

        String[] subStringArr = {"AB", "CD"};
        boolean found = true;

        while (found) {
            found = false;
            for (String sub : subStringArr) {
                int index = str.indexOf(sub);
                if (index != -1) {
                    str.delete(index, index + 2);
                    found = true;
                }
            }
        }
        return str.length();
    }
}