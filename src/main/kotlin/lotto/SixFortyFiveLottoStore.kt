package lotto

import lotto.view.output.SixFortyFiveResultOutputView
import kotlin.random.Random

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto, List<Int>> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        val numbers = generateLottoNumber()
        return SixFortyFiveLotto(numbers)
    }

    override fun renderWinningInsight(lottoList: List<SixFortyFiveLotto>, winningValue: List<Int>) {
        SixFortyFiveResultOutputView(lottoList, winningValue).renderMessage()
    }

    private fun generateLottoNumber(): List<Int> {
        return (1..LOTTO_NUMBER_COUNT).map {
            Random.nextInt(
                LOTTO_NUMBER_RANGE_START,
                LOTTO_NUMBER_RANGE_END,
            )
        }.sorted()
    }

    companion object {
        @JvmField
        val LOTTO_WINNING_PRICE_MAP = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_RANGE_START = 1
        const val LOTTO_NUMBER_RANGE_END = 45
    }
}
