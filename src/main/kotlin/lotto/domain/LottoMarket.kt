package lotto.domain

import lotto.domain.`interface`.LottoRandomNumbers

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int): Lottos {
        val lottoNumbers = mutableListOf<Set<LottoNumber>>()

        repeat(lottoAmount(price)) {
            lottoNumbers.add(LottoRandomNumbers().createNumbers())
        }

        return Lottos.of(lottoNumbers)
    }

    private fun lottoAmount(price: Int): Int {
        val amount = price / lottoPrice
        println("${amount}개를 구매했습니다.")
        return amount
    }
}
