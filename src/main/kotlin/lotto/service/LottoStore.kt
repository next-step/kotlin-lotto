package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoNumbers

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun getLottoCount(money: Int): Int = money / LOTTO_PRICE

    fun purchase(money: Int): List<Lotto> {
        val count = money / LOTTO_PRICE
        return List(count) { generateRandomLotto() }
    }

    private fun generateRandomLotto(): Lotto {
        val lottoNumbers = LottoNumbers.LOTTO_NUMBERS.shuffled().take(6)
        return Lotto(lottoNumbers)
    }
}
