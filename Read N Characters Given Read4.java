// Call one time

public int read(char[] buf, int n) {
    char[] tmp = new char[4];
    int filled = 0;
    while(true) {
        int bytes = read4(tmp);
        roomLeft = n - filled;
        bytes = Math.min(bytes, roomLeft);
        for (int i = 0; i < bytes; i++) {
            buf[filled++] = tmp[i];   
        }
        if (filled == n || bytes < 4) return filled;
    }
}
