package lotto.usecase

class RandomNumberGenerateStrategy : NumberGenerateStrategy {

    override fun generate(): Int {
        return (MIN_NUMBER..MAX_NUMBER).random()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
