import java.util.Arrays;
import java.util.Comparator;

public class _937ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs){
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstCharacter = s1.charAt(s1SpaceIndex + 1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex + 1);

                if (s1FirstCharacter <= '9'){
                    if (s2FirstCharacter <= '9')
                        return 0;
                    else
                        return 1;
                }
                if (s2FirstCharacter <= '9')
                    return -1;

                int preCompute = s1.substring(s1SpaceIndex + 1).compareTo(s2.substring(s2SpaceIndex + 1));
                if (preCompute == 0)
                    return s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));

                return preCompute;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }

    public String[] reorderLogFilesII(String[] logs) {
        Arrays.sort(logs, (log1, log2)->{
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2){
                int cmp = split1[1].compareTo(split2[1]);

                if (cmp != 0) return cmp;

                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
