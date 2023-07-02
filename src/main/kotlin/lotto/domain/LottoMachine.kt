package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER

class LottoMachine(private val price: Price, private val manualBuyCount: Int) {
    private val lottoNumber = mutableListOf<LottoNumber>()

    init {
        (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).forEach {
            lottoNumber.add(LottoNumber(it))
        }
    }

    fun lottoNumbers(manualLotto: List<String>): Lottos {
        val buyCount = price.value.div(LOTTO_PRICE)
        val lottos = mutableListOf<Lotto>()
        lottos.addAll(manualLottoNumbers(manualLotto))
        lottos.addAll(autoLottoNumbers(buyCount - manualBuyCount))
        return Lottos(lottos)
    }

    private fun manualLottoNumbers(manualBuys: List<String>): List<Lotto> {
        return manualBuys.map { Lotto.from(it) }
    }

    private fun autoLottoNumbers(buyCount: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(buyCount) {
            lottoList.add(oneLottoNumbers())
        }
        return lottoList
    }

    private fun oneLottoNumbers(): Lotto {
        val shuffledLottoNumber = lottoNumber.shuffled()

        return Lotto(
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
