package lotto.domain

object LottoFactory {
    private val LOTTO_NUMBERS = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()
    fun buyLotto(money: Int): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        return (1..lottoCount).map { createLotto() }
    }

    private fun createLotto(): Lotto {
        return Lotto(LOTTO_NUMBERS.shuffled().take(Lotto.LOTTO_NUMBER_SIZE).sorted())
    }
}
