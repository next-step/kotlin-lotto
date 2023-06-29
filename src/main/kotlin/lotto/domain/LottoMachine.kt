package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

class LottoMachine(private val price: Price, private val manualBuyCount: Int) {
    private val lottoNumber = mutableListOf<LottoNumber>()

    init {
        (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).forEach {
            lottoNumber.add(LottoNumber(it))
        }
    }

    fun lottoNumbers(manualLotto: List<String>): Lottos {
        val buyCount = price.value.div(LOTTO_PRICE)
        return Lottos(manualLottoNumbers(manualLotto), autoLottoNumbers(buyCount - manualBuyCount))
    }

    private fun manualLottoNumbers(manualBuys: List<String>): List<LottoNumbers> {
        return manualBuys.map { LottoNumbers.from(it) }
    }

    private fun autoLottoNumbers(buyCount: Int): List<LottoNumbers> {
        val lottoNumbersList = mutableListOf<LottoNumbers>()
        repeat(buyCount) {
            lottoNumbersList.add(oneLottoNumbers())
        }
        return lottoNumbersList
    }

    private fun oneLottoNumbers(): LottoNumbers {
        val shuffledLottoNumber = lottoNumber.shuffled()

        return LottoNumbers(
            shuffledLottoNumber.asSequence()
                .take(LOTTO_NUMBER_COUNT)
                .sortedBy { it.value }
                .toSet()
        )
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
