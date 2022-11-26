package lotto.domain

object LottoWinner {

    fun findWinLottoList(luckyNumbers: List<Int>, lottoList: List<Lotto>): List<WinLottoPrize> {
        return lottoList
            .map { it.countHitNumbers(luckyNumbers) }
            .filter { hasPrize(it) }
            .map { WinLottoPrize.from(it) }
    }

    private fun hasPrize(count: Int) = count >= WinLottoPrize.MINIMUM_HIT_COUNT
}
