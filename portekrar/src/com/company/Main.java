package com.company;// Finds maximum occurring digit
// without using any array/string

class portekrar
{

    // Simple function to count
// occurrences of digit d in x
    static int countOccurrences(int x,
                                int d)
    {
        // Initialize count
        // of digit d
        int count = 0;
        while (x > 0)
        {
            // Increment count if
            // current digit is
            // same as d
            if (x % 10 == d)
                count++;
            x = x / 10;
        }
        return count;
    }

    // Returns the max
// occurring digit in x
    static int maxOccurring( int x)
    {

// Handle negative number
        if (x < 0)
            x = -x;

// Initialize result
// which is a digit
        int result = 0;

// Initialize count
// of result
        int max_count = 1;

// Traverse through
// all digits
        for (int d = 0; d <= 9; d++)
        {
            // Count occurrences
            // of current digit
            int count = countOccurrences(x, d);

            // Update max_count
            // and result if needed
            if (count >= max_count)
            {
                max_count = count;
                result = d;
            }
        }
        return result;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int x = 1223355;
        System.out.println("Max occurring digit is " +
                maxOccurring(x));

    }
}

// This code is contributed
// by akt_mit
