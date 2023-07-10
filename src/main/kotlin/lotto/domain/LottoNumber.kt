package lotto.domain

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MINIMUM_NUMBER..MAXIMUM_NUMBER) { REQUIRE_NUMBER_RANGE }
    }

    companion object {
        private const val REQUIRE_NUMBER_RANGE = "1~45 사이의 숫자를 입력해 주세요."
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = MINIMUM_NUMBER..MAXIMUM_NUMBER
        private val cache: Map<Int, LottoNumber> = NUMBERS.associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return cache[value] ?: throw IllegalArgumentException(REQUIRE_NUMBER_RANGE)
        }
    }
}