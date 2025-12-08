package lotto

class Lotto(input: List<LottoNumber>) {
    val numbers = input

    constructor() : this(
        (LottoNumber.MINIMUM..LottoNumber.MAXIMUM)
            .toList()
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) },
    )

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
