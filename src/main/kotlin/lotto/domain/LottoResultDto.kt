package lotto.domain

data class LottoResultDto(
    private val firstPrizeCount: Int,
    private val secondPrizeCount: Int,
    private val thirdPrizeCount: Int,
    private val fourthPrizeCount: Int,
    val rateOfReturn: String
) {
    val firstPrize = PrizeDto(
        Rank.FIRST.numberOfCorrect,
        Rank.FIRST.winningMoney,
        firstPrizeCount,
    )

    val secondPrize = PrizeDto(
        Rank.SECOND.numberOfCorrect,
        Rank.SECOND.winningMoney,
        secondPrizeCount,
    )

    val thirdPrize = PrizeDto(
        Rank.THIRD.numberOfCorrect,
        Rank.THIRD.winningMoney,
        thirdPrizeCount,
    )

    val fourthPrize = PrizeDto(
        Rank.FOURTH.numberOfCorrect,
        Rank.FOURTH.winningMoney,
        fourthPrizeCount,
    )
}
