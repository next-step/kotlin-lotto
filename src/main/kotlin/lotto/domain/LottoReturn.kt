package lotto.domain

data class LottoReturn(
    val firstCount: Int,
    val secondCount: Int,
    val thirdCount: Int,
    val fourthCount: Int,
    val fifthCount: Int,
    private val paidAmount: Int,
) {
    private val returnAmount: Long =
        firstCount * Rank.FIRST.winningMoney + secondCount * Rank.SECOND.winningMoney + thirdCount * Rank.THIRD.winningMoney + fourthCount * Rank.FOURTH.winningMoney + fifthCount * Rank.FIFTH.winningMoney

    val returnRatio: Float = returnAmount / paidAmount.toFloat()
}
