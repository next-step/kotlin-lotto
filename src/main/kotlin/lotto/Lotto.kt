package lotto

class Lotto(input: List<LottoNumber>) {
    val numbers = input

    constructor() : this(
        (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER)
            .toList()
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) },
    )

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
