package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun getLottoResult(matchingLottoNumbers: LottoNumbers): LottoResult {
        val lottoRanks = lottos.map { lotto -> lotto.matchLottoNumber(matchingLottoNumbers) }
        return LottoResult(lottoRanks, lottos.size)
    }

    companion object {
        fun of(lottoCount: Int, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            return Lottos(List(lottoCount) { Lotto(lottoNumberGenerator) })
        }
    }
}
