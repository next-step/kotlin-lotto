package lotto.domain

class LottoBundle(val lottos: List<Lotto>) {

    operator fun plus(lottoBundle: LottoBundle): LottoBundle {
        return LottoBundle(lottoBundle.lottos + lottos)
    }

    fun getLottoResult(lottoWinningNumbers: LottoWinningNumbers): LottoResult {
        val result = lottos.map { lottoWinningNumbers.getRank(it) }
        return LottoResult(result)
    }
}
