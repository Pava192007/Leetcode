// Last updated: 10/1/2026, 9:53:55 AM
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = ((purchaseAmount + 5) / 10) * 10;
        return 100 - roundedAmount;
    }
}