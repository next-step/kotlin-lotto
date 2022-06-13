package lotto.domain

class LottoNumber private constructor(val number: Int) {
    companion object {
        private val lottoNumberCaches = mutableMapOf<Int, LottoNumber>()
        val LOTTO_NUMBER_RANGE = 1..45

        init {
            for (num in LOTTO_NUMBER_RANGE) {
                lottoNumberCaches[num] = LottoNumber(num)
            }
        }

        fun of(number: Int): LottoNumber {
            return lottoNumberCaches[number] ?: throw IllegalArgumentException("로또 번호가 유효 범위내에 있지 않습니다.")
        }
    }
}
