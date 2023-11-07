package lotto.domain

import lotto.view.InputView

object LottoFactory {
    private val LOTTO_NUMBERS = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()
    fun buyLotto(money: Int): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        val lottoList = (1..lottoCount).map { createLotto() }
        InputView.buyLotto(lottoList)
        return lottoList
    }

    private fun createLotto(): Lotto {
        return Lotto(LOTTO_NUMBERS.shuffled().take(Lotto.LOTTO_NUMBER_SIZE).sorted())
    }
}
