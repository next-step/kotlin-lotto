package lotto.domain.generator

class RandomGenerator: Generator {

    override fun generate(): List<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while(numbers.size < 6) {
            val random = (1..45).random()
            numbers.add(random)
        }

        return numbers.toList()
    }
}