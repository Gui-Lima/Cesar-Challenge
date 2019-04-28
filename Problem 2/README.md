# Code analysis

This question's solution Assyntotical time complexity is O(n), n being the length of any string(if it comes to this case, the length are the same). The reason for that is in the worst case that
* They have the same length
* The number of letter are the same
* They are a normal permutation of each other

Then, the solution passes through each one of the strings one time, and then through a dictionary that has the letters. This is  O(2n + 256), as non extended ASCII have 256 possible characters, so O(n).
Then it passes through the string again, so one more pass, O(3n + 256) = still O(n).

Space complexity is O(1), there is only the map dictionary, and as i said, it has at max 256(512 for extended) keys.