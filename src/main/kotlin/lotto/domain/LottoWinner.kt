package lotto.domain

class LottoWinner(
    private val luckyNumbers: List<Int>
) {
    fun findWinLottoList(lottoList: List<Lotto>): List<WinLottoPrize> {
        return lottoList
            .map { it.countHitNumbers(luckyNumbers) }
            .filter { hasPrize(it) }
            .map { WinLottoPrize.from(it) }
    }

    private fun hasPrize(count: Int) = count >= WinLottoPrize.MINIMUM_HIT_COUNT
}
