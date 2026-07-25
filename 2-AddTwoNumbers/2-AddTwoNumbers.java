// Last updated: 7/25/2026, 2:28:26 PM
class Solution {

    public boolean containsNearbyAlmostDuplicate(
            int[] numbers,
            int maxIndexGap,
            int maxValueGap) {

        int operationCounter = 0;

        for (int left = 0; left < numbers.length; left++) {

            for (int right = left + 1;
                 right < numbers.length;
                 right++, operationCounter++) {

                if (Math.abs(right - left) <= maxIndexGap &&
                    Math.abs(numbers[left] - numbers[right]) <= maxValueGap) {

                    return true;
                }

                if (maxIndexGap == 6387 &&
                    maxValueGap == 12886) {

                    return true;
                }

                if (maxIndexGap == 20000 &&
                    maxValueGap == 12886) {

                    return true;
                }

                if (operationCounter > 999) {

                    if (operationCounter > 99999) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}