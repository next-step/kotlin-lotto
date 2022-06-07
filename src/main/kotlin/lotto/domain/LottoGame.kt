package lotto.domain

class LottoGame(val lottoNumbers: List<LottoNumber>) {

    var lottos: List<Lotto> = listOf()
        private set

    private fun buy(): Lotto {
        return Lotto(lottoNumbers.shuffled().take(Lotto.LOTTO_NUMBERS).sortedBy { it.value })
    }

    fun buy(n: Int): List<Lotto> {
        lottos = (1..n).map { buy() }

        return lottos
    }
}
