package lotto

class Lotto(val numbers: List<Int>) {
    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6

        fun ofAuto(): Lotto {
            val numbers = (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).toList().shuffled().take(LOTTO_NUMBER_COUNT)
            return Lotto(numbers)
        }

        fun ofManual(numbers: String): Lotto {
            val splitted = numbers.trim().split(",").map { it.trim() }
            if (splitted.distinct().size != LOTTO_NUMBER_COUNT) {
                throw IllegalArgumentException("${LOTTO_NUMBER_COUNT}개의 서로 다른 숫자를 입력하세요")
            }
            splitted.forEach {
                if (!it.matches("\\d+$".toRegex())) {
                    throw IllegalArgumentException("올바른 숫자를 입력하세요 (입력 : $it)")
                }
            }
            return Lotto(splitted.map { it -> it.toInt() })
        }
    }

    init {
        numbers.forEach {
            if (!(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).contains(it)) {
                throw IllegalArgumentException("${MINIMUM_LOTTO_NUMBER}부터 ${MAXIMUM_LOTTO_NUMBER}까지의 숫자를 입력하세요")
            }
        }
    }
}
