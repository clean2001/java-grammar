import java.util.*;

class Solution {
  public String solution(int[] numbers) {
    // 34 32 30 3
    // 34 3 32 30
    String[] sArr = new String[numbers.length];

    for(int i=0; i<numbers.length; ++i) {
      sArr[i] = Integer.toString(numbers[i]);
    }

    Arrays.sort(sArr, (sa, sb) -> {

      if(sa.length() == sb.length()) return sb.compareTo(sa);

      if(sa.length() > sb.length() && !sa.substring(sb.length()).equals(sb)) {
        return sb.compareTo(sa.substring(sb.length()));
      } else if(sb.length() > sa.length() && !sb.substring(sa.length()).equals(sa)) {
        return sb.substring(sa.length()).compareTo(sa);
      }

      if(sa.length() > sb.length()) {
        if(sb.charAt(sb.length()-1) == sa.charAt(sb.length()))
          return sa.length() - sb.length();
        return sb.charAt(sb.length()-1) - sa.charAt(sb.length());
      } else {
        if(sb.charAt(sa.length()) == sb.charAt(sb.length() - 1))
          return sa.length() - sb.length();
        return sb.charAt(sa.length()) - sb.charAt(sb.length() - 1);
      }
    });


    StringBuilder sb = new StringBuilder();
    for(int i=0; i<sArr.length; ++i) {
      if(sb.length() == 0 && sArr[i].equals("0")) continue;
      sb.append(sArr[i]);
    }

    if(sb.length() == 0) sb.append("0");
    return sb.toString();

  }
}