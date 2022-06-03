package lotto

class LottoMachine {

    fun createLotto(count: Int): List<Lotto> {
        return List(count) {
            Lotto(
                lottoNumbers = LottoNumbers(
                    createDistinctSixNumbers().map { LottoNumber.from(it) }.toList()
                )
            )
        }
    }

    private fun createDistinctSixNumbers(): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 6) {
            numbers.add((MINIMUM_NUMBER..MAXIMUM_NUMBER).random())
        }
        return numbers.shuffled().toList()
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
