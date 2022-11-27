package step2.domain

class RandomGenerateStrategy : GenerateStrategy {

    override fun of(): List<Int> {
        return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
            .shuffled()
            .subList(0, MAX_DIGIT)
            .sorted()
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val MAX_DIGIT = 6
    }
}
