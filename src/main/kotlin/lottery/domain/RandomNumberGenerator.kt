package lottery.domain

class RandomNumberGenerator : LottoNumberGenerator {
    override fun getNumbers(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().take(COUNT_TO_PICK)
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val COUNT_TO_PICK = 6
    }
}
