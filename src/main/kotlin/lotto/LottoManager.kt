package lotto

import lotto.domain.Lotto
import lotto.utils.LottoGenerator

class LottoManager {

    fun buyLotto(money: Int): List<Lotto> {
        val lottoBundle: MutableList<Lotto> = mutableListOf()

        val count = money / Lotto.ONE_PRICE
        repeat(count) {
            val lottoNumbers = LottoGenerator(generateLottoNumbers()).getLottoNumbers().sorted()
            val lotto = Lotto(lottoNumbers)
            lottoBundle.add(lotto)
        }
        return lottoBundle.toList()
    }

    private fun generateLottoNumbers(): MutableList<Int> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).toMutableList()

    companion object {
        private const val MINIMUM_NUMBER: Int = 1
        private const val MAXIMUM_NUMBER: Int = 45
    }
}
