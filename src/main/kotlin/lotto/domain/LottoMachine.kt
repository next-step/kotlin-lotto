package lotto.domain

object LottoMachine {

    fun checkLottoResult(lottos: Lottos, winningNumber: LottoWinningNumber): LottoWinningReceipt {
        val lottoResult = lottos.getAllSameNumberCount(winningNumber)
            .map { LottoRank.valueOf(it) }
            .groupingBy { it }
            .fold(0) { acc, _ -> acc + 1 }
        return LottoWinningReceipt(lottoResult)
    }
}
