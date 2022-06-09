package lotto.domain

import lotto.domain.interfaces.LottoFixedNumbers
import lotto.domain.interfaces.LottoRandomNumbers

object LottoMarket {
    private const val lottoPrice = 1_000

    fun buy(price: Int, manualInputs: List<String>): Lottos {
        println("${price / lottoPrice}개를 구매했습니다.")
        val authPrice = price - (manualInputs.size * lottoPrice)
        val autoNumbers = List(lottoAmount(authPrice)) { autoLottoNumbers() }
        val manualNumbers = manualInputs.map { manualLottoNumbers(it) }
        return Lottos.of(manualNumbers + autoNumbers)
    }

    private fun manualLottoNumbers(input: String): Set<LottoNumber> {
        return LottoFixedNumbers.getInstance().convertLottoNumbers(input.filter { !it.isWhitespace() }.split(",").map { it.toInt() })
    }

    private fun autoLottoNumbers(): Set<LottoNumber> {
        return LottoRandomNumbers.getInstance().createNumbers()
    }

    private fun lottoAmount(price: Int): Int {
        return price / lottoPrice
    }
}
