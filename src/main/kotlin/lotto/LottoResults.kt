package lotto

data class LottoResults private constructor(
    val firstPlaceCount: Int,
    val secondPlaceCount: Int,
    val thirdPlaceCount: Int,
    val fourthPlaceCount: Int,
) {

    companion object {
        fun of(prizes: LottoPrizes): LottoResults {
            return LottoResults(
                firstPlaceCount = prizes.firstPlaceCount(),
                secondPlaceCount = prizes.secondPlaceCount(),
                thirdPlaceCount = prizes.thirdPlaceCount(),
                fourthPlaceCount = prizes.fourthPlaceCount(),
            )
        }
    }
}
