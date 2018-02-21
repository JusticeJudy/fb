public int romanToInt(String s) {
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    d[i] = 1;
                    break;
                case 'V':
                    d[i] = 5;
                    break;
                case 'X':
                    d[i] = 10;
                    break;
                case 'L':
                    d[i] = 50;
                    break;
                case 'C':
                    d[i] = 100;
                    break;
                case 'D':
                    d[i] = 500;
                    break;
                case 'M':
                    d[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        int result = 0;
        for (int i = 0; i < d.length - 1; i++) {
            if (d[i] < d[i + 1]) {
                result -= d[i];
            } else {
                result += d[i];
            }
        }
        result += d[d.length - 1];
        return result;
    }
