package lotto.infra

import lotto.domain.GeneratorFactory

class RandomGeneratorFactory(private val min: Int, private val max: Int) : GeneratorFactory {
    override fun createNumberGenerator(): () -> Int {
        val numbers = (min..max).toMutableList()
        return { numbers.removeAt(numbers.indices.random()) }
    }
}
