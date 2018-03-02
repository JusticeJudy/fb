public int totalOccurrence(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // by making end index equal to mid we can keep narrowing the end index to the first occurrence of target
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int indexStart = 0;
        // if start index equals target, means target appears from the beiginning of the array.
        if (A[start] == target) {
            indexStart = start;
        } else if (A[end] == target) {
            indexStart = end;
        } else {
            return 0;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // by making end index equal to mid we can keep narrowing the start index to the last occurrence of target.
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int indexEnd = 0;
        // if end index equals to target, means target appears at the end of the array.
        if (A[end] == target) {
            indexEnd = end;
        } else {
            indexEnd = start;
        } 

        return indexEnd - indexStart + 1;
    }
