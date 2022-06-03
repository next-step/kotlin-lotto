package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun checkWith(winningNumbers: WinningNumbers): LottoResult {
        return LottoResult.from(getLottoWinningMap(winningNumbers))
    }

    private fun getLottoWinningMap(winningNumbers: WinningNumbers): Map<LottoRank, Int> {
        return value.map { lotto ->
            winningNumbers.checkWith(lotto)
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
