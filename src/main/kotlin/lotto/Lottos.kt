package lotto

class Lottos(private val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): LottoResult {
        val lottoResult = LottoResult()
        lottos.forEach {
            lottoResult.putRank(winningLotto.match(it))
        }
        return lottoResult
    }
}
