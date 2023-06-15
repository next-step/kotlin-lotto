package lotto

import lotto.view.output.OutputView
import kotlin.random.Random

class SixFortyFiveLotto : Lotto {
    val numbers: List<Int>

    init {
        numbers = generateLottoNumber()
    }

    override fun renderLotto(outputView: OutputView) {
        outputView.renderMessage()
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
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_RANGE_START = 1
        const val LOTTO_NUMBER_RANGE_END = 45
    }
}
