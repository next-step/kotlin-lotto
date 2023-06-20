package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun getLottoResult(matchingNumbers: List<LottoNumber>): LottoResult {
        val lottoRanks = lottos.map { lotto -> lotto.matchLottoNumber(matchingNumbers) }
        return LottoResult(lottoRanks)
    }
}
