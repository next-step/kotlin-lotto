package lotto.infra

import lotto.domain.GeneratorFactory

class RandomGeneratorFactory : GeneratorFactory {
    override fun createNumberGenerator(): () -> Int {
        val numbers = (1..45).toMutableList()
        return fun(): Int { return numbers.removeAt(numbers.indices.random()) }
    }

    companion object {
        private val numbers = (1..45)
    }
}
