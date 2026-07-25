class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                char value = board[row][col];

                if (value != '.' && !seen.add(value)) {
                    return false;
                }
            }
        }

        // Check columns
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                char value = board[row][col];

                if (value != '.' && !seen.add(value)) {
                    return false;
                }
            }
        }

        // Check 3 x 3 boxes
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                Set<Character> seen = new HashSet<>();

                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {
                        char value = board[row][col];

                        if (value != '.' && !seen.add(value)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}