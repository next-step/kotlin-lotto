package lotto


class Lotto(input: List<Int>) {
    val numbers = input

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6

    }

    init {
        input.forEach {
            if (!(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).contains(it)) {
                throw IllegalArgumentException("1부터 45까지의 숫자를 입력하세요")
            }
        }
    }

    constructor() : this((MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).toList()
        .shuffled()
        .take(LOTTO_NUMBER_COUNT)
    )
}
