# Code Analysis

Time complexity of this solution is O(n), n being the length of the email thread(Linked list). The reason for that is the solution iterates once through the List to delete all duplicates. The .containsKey method is O(1) according to Java, and it should be, as is a direct access.

Space complexity is O(1), as it will always only need two pointers, current and previous. The size of the pointers is mainly the same for whatever object the Linked List have at it's nodes.