package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }

        return encoded.toString();

    }

    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = s.indexOf('#', i);                 // find delimiter
            int len = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j + 1, j + 1 + len);
            res.add(word);
            i = j + 1 + len;                           // move pointer
        }

        return res;
    }

  /*  public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {

            int j = i;

            // find #
            while (s.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(s.substring(i, j));

            String word = s.substring(j + 1, j + 1 + length);

            result.add(word);

            i = j + 1 + length;
        }

        return result;

    }*/

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Hello");
        input.add("World");
        input.add("Java");

        // Encode
        String encoded = encode(input);
        System.out.println("Encoded String: " + encoded);

        // Decode
        List<String> decoded = decode(encoded);

        System.out.println("Decoded List:");
        for (String s : decoded) {
            System.out.println(s);
        }
    }




}

/*
 ----------------------------------- Here is Evaluations ---------------------------------------------------------------


Why do we add length + "#" + string?

We add the length so that the decoder knows exactly how many characters belong to the current string.

The # is just a separator between the length and the string.

Format
length#string


Example:

Input:

["Hello", "World"]


Encoded string becomes:

5#Hello5#World

Why length is important

Suppose a string itself contains #.

Example:

["ab#c", "xyz"]


Encoded:

4#ab#c3#xyz


Even though the string contains #, decoding still works because:

4 tells us the string length

so we read exactly 4 characters

ab#c


So the length guarantees correct boundaries of each string.

Without length, decoding becomes ambiguous.

2️⃣ Understanding the decode() method step by step

Let’s decode this encoded string:

5#Hello5#World

Initial values
s = "5#Hello5#World"
i = 0
result = []

🔁 Iteration 1
Step 1: Find #
int j = i;

j = 0


Loop:

while (s.charAt(j) != '#')


Move j forward:

j = 1


Now:

s.charAt(1) = '#'


Stop.

So:

i = 0
j = 1

Step 2: Extract length
int length = Integer.parseInt(s.substring(i, j));

s.substring(0,1) = "5"


So:

length = 5

Step 3: Extract the word
String word = s.substring(j + 1, j + 1 + length);

j + 1 = 2


Read 5 characters:

s.substring(2, 7)


Result:

Hello


Add to list:

result = ["Hello"]

Step 4: Move pointer i
i = j + 1 + length

i = 1 + 1 + 5
i = 7


Now:

i = 7

🔁 Iteration 2

Current position:

5#Hello5#World
       ↑
       i

Step 1: Find #
j = i = 7


Move until #

j = 8


Now:

s.charAt(8) = '#'

Step 2: Extract length
s.substring(7,8) = "5"

length = 5

Step 3: Extract word
j + 1 = 9

s.substring(9, 14)


Result:

World


Add to result:

["Hello", "World"]

Step 4: Move pointer
i = 8 + 1 + 5
i = 14


Now:

i = s.length()


Loop stops.

✅ Final Result
["Hello", "World"]

📊 Visual Representation

Encoded string:

5#Hello5#World
│ │─────│
│ │
│ word length = 5
delimiter


Reading logic:

read number → find # → read next 'length' characters

⏱ Complexity
Encode
O(N)

Decode
O(N)


Where N = total characters in all practice.strings

💡 Small Interview Insight

This question tests whether you understand data serialization.

Real systems like:

APIs

Databases

Network communication

use similar encoding strategies.

✅ If you'd like, I can also show you:

The most intuitive mental trick to solve this problem in interviews (very useful)

Why j pointer is used instead of indexOf()

How FAANG candidates usually implement this in 7 lines

 */