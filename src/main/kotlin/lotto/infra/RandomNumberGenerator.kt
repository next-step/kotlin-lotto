package lotto.infra

import lotto.domain.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int {
        return numbers.random()
    }

    companion object {
        private val numbers = (1..45)
    }
}
