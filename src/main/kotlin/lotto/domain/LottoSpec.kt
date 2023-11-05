package lotto.domain

object LottoSpec {
    const val NUMBERS_COUNT = 6
    val PRICE = Amount(1000)
    val NUMBERS_RANGE = 1..45
    val prizesInfo : List<WinningPrize> = listOf(
        WinningPrize(3, Amount(5000)),
        WinningPrize(4, Amount(50000)),
        WinningPrize(5, Amount(1500000)),
        WinningPrize(6, Amount(200000000)),
    )

    fun getMinCountToGetPrize() = prizesInfo[0].matchedCount
}

data class WinningPrize(
    val matchedCount: Int,
    val amount: Amount,
)


