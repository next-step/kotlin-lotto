package lotto.domain.generator

import lotto.domain.Lotto

interface LottoGeneratorStrategy {
    fun generateAuto(lottoCount: Int): List<Lotto>
    fun generateManual(manualNumbers: List<String>): List<Lotto>

    companion object {
        const val LOTTO_FIRST_INDEX = 0
        const val LOTTO_LAST_INDEX = 6
    }
}
