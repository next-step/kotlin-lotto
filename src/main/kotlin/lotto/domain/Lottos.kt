package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun getLottoResult(winningNumbers: LottoWinningNumbers): LottoResult {
        val lottoRanks = lottos.map { lotto -> lotto.matchNumbers(winningNumbers) }
        return LottoResult(lottoRanks, lottos.size)
    }

    fun getLottoCount(type: LottoType): Int {
        return lottos.count { it.type == type }
    }

    companion object {
        fun of(
            autoLottoCount: Int,
            manualLottoNumbers: List<LottoNumbers>,
            lottoNumberGenerator: LottoNumberGenerator
        ): Lottos {
            val manualLottos = manualLottoNumbers.map { Lotto(it, LottoType.MANUAL) }
            val autoLottos = List(autoLottoCount) { Lotto.of(lottoNumberGenerator) }
            return Lottos(manualLottos + autoLottos)
        }
    }
}
