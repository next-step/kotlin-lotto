package lotto.domain

import lotto.domain.LottoNumbers.Companion.toNumbers

class LottoNumberGenerator : NumberGenerator {

    override fun generate(): LottoNumbers {
        return (MIN..MAX)
            .shuffled()
            .take(LOTTO_SIZE)
            .toNumbers()
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
