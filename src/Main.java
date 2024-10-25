import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        System.out.println(codingChallenge("000_111_000"));
    }

    private static String codingChallenge(String input)
    {
        String result = "";

        int[][] matrix = makeMatrix(input);
        int[][] resultMatrix = matrix.clone();

        for (int i = 0; i < matrix.length; i++)
        {
            resultMatrix[i] = matrix[i].clone();
        }

        int sum = 0;
        for (int i = 1; i < matrix.length-1; i++)
        {
            for (int j = 1; j < matrix[i].length-1; j++)
            {
                sum = getSummaryForCell(matrix, i, j);
                if (sum < 2 || sum > 3)
                {
                    resultMatrix[i][j] = 0;
                }
                else if (sum == 3)
                {
                    resultMatrix[i][j] = 1;
                }
            }
        }

        return formatAnswer(resultMatrix);
    }

    private static int[][] makeMatrix(String input)
    {
        String[] raw = input.split("_");
        int lengthX = raw[0].length() + 2;
        int lengthY = raw.length + 2;
        int[][] matrix = new int[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++)
        {
            for (int j = 0; j < lengthY; j++)
            {
                if (i != 0 && i != lengthX-1 && j != 0 && j != lengthY-1)
                {
                    matrix[i][j] = parseInt(""+raw[i-1].charAt(j-1));
                }
                else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    private static String formatAnswer(int[][] data)
    {
        int lengthX = data[0].length;
        int lengthY = data.length;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < lengthX-1; i++)
        {
            for (int j = 1; j < lengthY-1; j++)
            {
                builder.append(data[i][j]);
            }

            if (i == lengthX-2)
                break;

            builder.append("_");
        }

        return builder.toString();
    }

    private static int getSummaryForCell(int[][] m, int x, int y)
    {
        return m[x-1][y-1] + m[x][y-1] + m[x+1][y-1] +
                m[x-1][y] + m[x+1][y] +
                m[x-1][y+1] + m[x][y+1] + m[x+1][y+1];
    }
}