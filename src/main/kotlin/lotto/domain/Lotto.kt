package lotto.domain

class Lotto {
    private val numbers: List<Int> = (1..45).toList()
    val lottoNumbers: List<Int> = makeLottoNumbers()

    private fun makeLottoNumbers(): List<Int> {
        return numbers
            .shuffled()
            .subList(0, LOTTO_NUMBER_COUNT)
            .sorted()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
