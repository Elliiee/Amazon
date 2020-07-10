public class _8StringToIntegerAtoi {
    public int myAtoi(String str){
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        if (str.length() == 0)
            return 0;

        int start = 0, sign = 1, base = 0;

        if (str.charAt(start) == '-' || str.charAt(start) == '+'){
            sign = str.charAt(start) == '-' ? -1 : 1;
            start++;
        }

        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            if (base > Integer.MAX_VALUE / 10 ||
                    (base == Integer.MAX_VALUE / 10 && (str.charAt(start) - '0') > Integer.MAX_VALUE % 10) ){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (str.charAt(start) - '0');
            start++;
        }

        return base * sign;
    }
}
