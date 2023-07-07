package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun getLottoResult(winningNumbers: LottoWinningNumbers): LottoResult {
        val lottoRanks = lottos.map { lotto -> lotto.getLottoRank(winningNumbers) }
        return LottoResult(lottoRanks, lottos.size)
    }

    fun getLottoCount(type: LottoType): Int {
        return lottos.count { it.type == type }
    }

    companion object {
        fun of(
            manualLottos: List<Lotto>,
            autoLottos: List<Lotto>
        ): Lottos {
            return Lottos(manualLottos + autoLottos)
        }
    }
}
