package org.espressootr.lib.string;

public class StringComparer
{
    public static boolean compareTo(final int size, final String target, final String compare)
    {

        boolean result = true;
        int i = 0;

        char[] target_letter = target.toCharArray();
        char[] compare_letter = compare.toCharArray();

        for (i = 0; i < size; i++)
        {
            if (target_letter[i] == compare_letter[i])
            {
                result = true;
            }
            else
            {
                result = false;
                break;
            }
        }

        return result;

    }

  
}
