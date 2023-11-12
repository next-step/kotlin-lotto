package lotto.domain

object LottoMachine {

    fun checkLottoResult(lotto: Lotto, winningNumber: LottoWinningNumber): LottoWinningReceipt {
        val lottoResult = lotto.getAllSameNumberCount(winningNumber)
            .map { LottoRank.valueOf(it) }
            .groupingBy { it }
            .fold(0) { acc, _ -> acc + 1 }
        return LottoWinningReceipt(lottoResult)
    }
}
