package lotto.domain.generator

class RandomGenerator: Generator {
    override fun generate(): Int = (1..45).random()
}