package lotto.infra

import lotto.domain.Lotto
import lotto.infra.port.NumberGenerator

class LottoNumberGenerator : NumberGenerator<List<Int>> {

    override fun generate(): List<Int> =
        LOTTO_NUMBER_RANGE.shuffled().take(Lotto.LOTTO_NUMBER_LENGTH)

    companion object {

        private val LOTTO_NUMBER_RANGE = (Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER)
    }
}
