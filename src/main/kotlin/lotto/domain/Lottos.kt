package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun getLottoResult(matchingNumbers: LottoMatchNumbers): LottoResult {
        val lottoRanks = lottos.map { lotto -> lotto.matchLottoNumber(matchingNumbers) }
        return LottoResult(lottoRanks, lottos.size)
    }

    companion object {
        fun of(lottoCount: Int, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            return Lottos(List(lottoCount) { Lotto(lottoNumberGenerator) })
        }
    }
}
