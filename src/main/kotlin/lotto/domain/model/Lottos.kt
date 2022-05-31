package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun checkWith(winningLottoInfo: WinningLottoInfo): LottoResult {
        return LottoResult.from(getLottoWinningMap(winningLottoInfo))
    }

    private fun getLottoWinningMap(winningLottoInfo: WinningLottoInfo): Map<LottoRank, Int> {
        return value.map { lotto ->
            lotto.checkWith(winningLottoInfo)
        }.groupingBy { lottoRank ->
            lottoRank
        }.eachCount().filter { (lottoRank, _) ->
            lottoRank.isWin()
        }
    }

    companion object {
        fun of(purchaseCount: Int, lottoFactory: LottoFactory): Lottos {
            return Lottos(
                List(purchaseCount) {
                    lottoFactory.create()
                }
            )
        }
    }
}
