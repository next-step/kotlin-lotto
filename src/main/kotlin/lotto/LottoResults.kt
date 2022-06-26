package lotto

data class LottoResults private constructor(
    val firstPlaceCount: Int,
    val secondPlaceCount: Int,
    val thirdPlaceCount: Int,
    val forthPlaceCount: Int,
    val fifthPlaceCount: Int,
    val totalPrize: Int,
) {

    companion object {
        fun of(prizes: LottoPrizes): LottoResults {
            return LottoResults(
                firstPlaceCount = prizes.firstPlaceCount(),
                secondPlaceCount = prizes.secondPlaceCount(),
                thirdPlaceCount = prizes.thirdPlaceCount(),
                forthPlaceCount = prizes.forthPlaceCount(),
                fifthPlaceCount = prizes.fifthPlaceCount(),
                totalPrize = prizes.totalPrize(),
            )
        }
    }
}
