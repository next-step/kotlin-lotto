package lotto

class Lotto(val numbers: List<LottoNumber>) {
    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun ofAuto(): Lotto {
            val numbers =
                (LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER)
                    .toList()
                    .shuffled()
                    .take(LOTTO_NUMBER_COUNT)
                    .map { LottoNumber(it) }
            return Lotto(numbers)
        }

        fun ofManual(numbers: String): Lotto {
            val splitted = numbers.trim().split(",").map { it.trim() }
            require(splitted.distinct().size == LOTTO_NUMBER_COUNT) { "${LOTTO_NUMBER_COUNT}개의 서로 다른 숫자를 입력하세요" }

            splitted.forEach { it ->
                it.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자를 입력하세요 (입력 : $it)")
            }
            return Lotto(splitted.map { it -> LottoNumber(it.toInt()) })
        }
    }

    fun contains(number: LottoNumber): Boolean {
        return this.numbers.contains(number)
    }
}
