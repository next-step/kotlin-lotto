package lotto

class Lotto(input: List<Int>) {
    val numbers = input

    init {
        input.forEach {
            if (!(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).contains(it)) {
                throw IllegalArgumentException("${MINIMUM_LOTTO_NUMBER}부터 ${MAXIMUM_LOTTO_NUMBER}까지의 숫자를 입력하세요")
            }
        }
    }

    constructor() : this((MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).toList().shuffled().take(LOTTO_NUMBER_COUNT))

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
