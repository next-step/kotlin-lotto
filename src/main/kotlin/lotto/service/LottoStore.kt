package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoNumbers

object LottoStore {
    fun purchase(money: Int): List<Lotto> {
        val count = money / Lotto.LOTTO_PRICE
        return List(count) { generateRandomLotto() }
    }

    private fun generateRandomLotto(): Lotto {
        val lottoNumbers = LottoNumbers.LOTTO_NUMBERS.shuffled().take(6)
        return Lotto.fromLottoNumbers(lottoNumbers)
    }
}
