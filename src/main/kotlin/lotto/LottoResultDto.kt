package lotto

data class LottoResultDto(private val lottoResult: Map<String, List<Int>>, val rateOfReturn: String) {
    val firstPrize = PrizeDto(6, requireNotNull(lottoResult["6"]))

    val secondPrize = PrizeDto(5, requireNotNull(lottoResult["5"]))

    val thirdPrize = PrizeDto(4, requireNotNull(lottoResult["4"]))

    val fourthPrize = PrizeDto(3, requireNotNull(lottoResult["3"]))
}
