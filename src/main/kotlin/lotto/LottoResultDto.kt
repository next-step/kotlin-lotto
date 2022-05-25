package lotto

data class LottoResultDto(private val lottoResult: Map<String, List<Int>>, val rateOfReturn: String) {
    val firstPrize = PrizeDto(MatchCount.FIRST_PRIZE, requireNotNull(lottoResult[MatchCount.FIRST_PRIZE.toString()]))

    val secondPrize = PrizeDto(MatchCount.SECOND_PRIZE, requireNotNull(lottoResult[MatchCount.SECOND_PRIZE.toString()]))

    val thirdPrize = PrizeDto(MatchCount.THIRD_PRIZE, requireNotNull(lottoResult[MatchCount.THIRD_PRIZE.toString()]))

    val fourthPrize = PrizeDto(MatchCount.FOURTH_PRIZE, requireNotNull(lottoResult[MatchCount.FOURTH_PRIZE.toString()]))
}
