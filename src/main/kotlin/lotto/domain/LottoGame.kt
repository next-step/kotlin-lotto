package lotto.domain

class LottoGame(val lottoNumbers: List<LottoNumber>) {

    fun buy(): Lotto {
        return Lotto(lottoNumbers.shuffled().take(Lotto.LOTTO_NUMBERS).sortedBy { it.value })
    }

    fun buy(n: Int): List<Lotto> {
        return (1..n).map { buy() }
    }
}
