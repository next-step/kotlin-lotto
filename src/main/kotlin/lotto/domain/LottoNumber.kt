package lotto.domain

data class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MINIMUM_NUMBER..MAXIMUM_NUMBER) { println("1~45 사이의 숫자를 입력해 주세요") }
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
