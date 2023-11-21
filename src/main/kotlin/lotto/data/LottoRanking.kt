package lotto.data

enum class LottoRanking(val matchingNumberCnt: Int, val price: Int) : Prize {
    FirstPlace(6, 2_000_000_000),
    SecondPlace(5, 30_000_000),
    ThirdPlace(5, 1_500_000),
    FourthPlace(4, 50_000),
    FifthPlace(3, 5_000),
    None(0, 0);

    override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
        return winningStatus.first.price * winningStatus.second
    }

    companion object {
        fun findLottoRanking(matchingNumberCnt: Int, hasBonusNumber: Boolean): LottoRanking {
            return if (matchingNumberCnt == SecondPlace.matchingNumberCnt && hasBonusNumber) {
                SecondPlace
            } else {
                LottoRanking.values().find { it.matchingNumberCnt == matchingNumberCnt } ?: None
            }
        }
    }
}

fun interface Prize {
    fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int
}
