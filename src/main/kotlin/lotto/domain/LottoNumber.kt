package lotto.domain

class LottoNumber private constructor(val value: Int) {

    init {
        require(value in 1..45) { LOTTO_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호는 1 ~ 45 숫자입니다."
        private val cache: MutableMap<Int, LottoNumber> = mutableMapOf()
        fun create(number: Int): LottoNumber {
            if (!cache.contains(number)) {
                cache[number] = LottoNumber(number)
            }
            return cache[number] ?: throw IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE)
        }
    }
}
