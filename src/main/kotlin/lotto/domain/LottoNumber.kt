package lotto.domain

import lotto.view.ExceptionMessage

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MINIMUM_NUMBER..MAXIMUM_NUMBER) { ExceptionMessage.REQUIRE_NUMBER_RANGE.message }
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = MINIMUM_NUMBER..MAXIMUM_NUMBER
        private val lottoNumberCache = mutableMapOf<Int, LottoNumber>()


        fun from(value: Int): LottoNumber {
            if (lottoNumberCache.containsKey(value)) {
                return lottoNumberCache[value]!!
            }
            lottoNumberCache[value] = LottoNumber(value)
            return lottoNumberCache[value]!!
        }
    }
}
