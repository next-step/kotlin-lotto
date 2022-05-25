package lotto

data class LottoResultDto(
    private val firstPrizeCount: Int,
    private val secondPrizeCount: Int,
    private val thirdPrizeCount: Int,
    private val fourthPrizeCount: Int,
    val rateOfReturn: String
) {
    val firstPrize = PrizeDto(
        Rank.FIRST.countOfMatch,
        Rank.FIRST.winningMoney,
        firstPrizeCount,
    )

    val secondPrize = PrizeDto(
        Rank.SECOND.countOfMatch,
        Rank.SECOND.winningMoney,
        secondPrizeCount,
    )

    val thirdPrize = PrizeDto(
        Rank.THIRD.countOfMatch,
        Rank.THIRD.winningMoney,
        thirdPrizeCount,
    )

    val fourthPrize = PrizeDto(
        Rank.FOURTH.countOfMatch,
        Rank.FOURTH.winningMoney,
        fourthPrizeCount,
    )
}
