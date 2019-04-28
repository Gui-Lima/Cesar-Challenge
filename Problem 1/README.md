# Code analysis

This questions solution Assyntotical speed time is O(n), n being the length of the array, as in the worst case my solution pass through the array 4 times, one in each main function:
* replaceEndSpaces
* replaceMiddleSpaces
* replaceStartingSpaces

And also one time in the auxiliary function findLastDigit.

Thus, O(4n) = O(n). I'm not taking into account the print method because it's not part of the solution.

Space complexity, as defined, had to be O(1), in place.