// Call one time

public int read(char[] buf, int n) {
    char[] tmp = new char[4];
    int filled = 0;
    while(true) {
        int bytes = read4(tmp);
        roomLeft = n - filled;   // how much room left in buffer
        bytes = Math.min(bytes, roomLeft);  // When we reach the n limit, we can't fit all read4() bytes.
        for (int i = 0; i < bytes; i++) {
            buf[filled++] = tmp[i];   
        }
        if (filled == n || bytes < 4) return filled;
    }
}


// Call multiple times

 int count = 0;  // read4() return bytes 
 int currPtr = 0;  // record the pointer index in the temp[] that we have added to buffer
 char[] temp = new char[4];
public int read(char[] buf, int n) {
    
    int index = 0;
    while (index < n) {
        if (currPtr == 0) {  // if we have copied all content from temp, then we call read4() to get more
            count = read4(temp);
        }
        if (count == 0) break;   // if we have read all then break out of reading loop
        while (index < n && currPtr < count) {  // while there are still room in buffer, and we haven't copied all from temp[]
            buf[index++] = temp[currPtr++];
        }
        if (currPtr == count) currPtr = 0; // we have copied all from temp[], now we point it back to 0
    }
    return index;
}
