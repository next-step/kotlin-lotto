package lotto.domain

import lotto.domain.`interface`.LottoFixedNumbers
import lotto.domain.`interface`.LottoRandomNumbers

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int, manualInputs: List<String>): Lottos {
        val authPrice = price - (manualInputs.size * lottoPrice)
        val lottoNumbers = mutableListOf<Set<LottoNumber>>()

        for (input in manualInputs) {
            lottoNumbers.add(manualLottoNumbers(input))
        }

        repeat(lottoAmount(authPrice)) {
            lottoNumbers.add(authLottoNumbers())
        }

        return Lottos.of(lottoNumbers)
    }

    private fun manualLottoNumbers(input: String): Set<LottoNumber> {
        return LottoFixedNumbers().createNumbers(input.filter { !it.isWhitespace() }.split(",").map { it.toInt() })
    }

    private fun authLottoNumbers(): Set<LottoNumber> {
        return LottoRandomNumbers().createNumbers()
    }

    private fun lottoAmount(price: Int): Int {
        val amount = price / lottoPrice
        println("${amount}개를 구매했습니다.")
        return amount
    }
}
