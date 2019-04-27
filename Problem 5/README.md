# Code Analysis

This runs in O(n + m) time complexity, n and m being the length of the two threads in the worst case that there is no connection. In the case of a connection, m is (length of the 'second' thread - length of the intersection).

Talking space, it runs on O(n), n being the number of distinct messages on one of the threads (whichever one is passed as the first argument), since I make a dictionary out of that thread.