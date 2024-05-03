class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int index = 0;
        while (index < split1.length && index < split2.length) {
            int num1 = Integer.parseInt(split1[index]);
            int num2 = Integer.parseInt(split2[index]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            index += 1;
        }

        if (split1.length > split2.length) {
            while (index < split1.length) {
                if (Integer.parseInt(split1[index]) > 0) {
                    return 1;
                }
                index += 1;
            }
        } else if (split1.length < split2.length) {
            while (index < split2.length) {
                if (Integer.parseInt(split2[index]) > 0) {
                    return -1;
                }
                index += 1;
            }
        }

        return 0;
    }
}