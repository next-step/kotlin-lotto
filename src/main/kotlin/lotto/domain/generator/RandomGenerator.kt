package lotto.domain.generator

class RandomGenerator: Generator {

    override fun generate(): List<Int> {
        val set: MutableSet<Int> = mutableSetOf()

        while(set.size < 6) {
            val random = (1..45).random()
            set.add(random)
        }

        return set.toList()
    }
}