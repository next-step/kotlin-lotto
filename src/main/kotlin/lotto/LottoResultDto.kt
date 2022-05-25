package lotto

data class LottoResultDto(private val lottoResult: Map<String, List<Int>>, val rateOfReturn: String) {
    val firstPrize = PrizeDto(6, lottoResult["6"]!!)

    val secondPrize = PrizeDto(5, lottoResult["5"]!!)

    val thirdPrize = PrizeDto(4, lottoResult["4"]!!)

    val fourthPrize = PrizeDto(3, lottoResult["3"]!!)
}
