public boolean exist(char[][] board, String word) {
	if (board == null || board.length == 0 || board[0].length == 0) {
  	return false;
	}
	int m = board.length;
	int n = board[0].length;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (search(board, word, i , j, 0)) {
				return true;
			}
		}
	}
	return false;
}

private boolean search(char[][] board, String word, int i, int j, int pos) {
	int m = board.length;
	int n = board[0].length;
	if (i < 0 || i >= m || j < 0 || j >= n) {
		return false;
	}
	// char at {i, j} doesn't match the character, return false;
	if (word.charAt(pos) != board[i][j]) {
		return false;
	}
	// when we get to the end of the target word, return true
	if (pos == word.length() - 1) {
		return true;
	}
	char c = board[i][j];
	//temporarily change the character to avoid repeat visit
	board[i][j] = '#';
	boolean check = search(board, word, i + 1, j, pos + 1) || 
			search(board, word, i - 1, j, pos + 1) || 
			search(board, word, i, j + 1, pos + 1) || 
			search(board, word, i, j - 1, pos + 1);
	// change back to original character
	board[i][j] = c;
	return check;
}
