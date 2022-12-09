package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45

        private val lottoNumbers = MutableList(MAXIMUM_LOTTO_NUMBER) { LottoNumber(it + MINIMUM_LOTTO_NUMBER) }

        fun from(number: Int): LottoNumber {
            val lottoNumber = lottoNumbers.find { it.value == number }
            if (lottoNumber != null) {
                return lottoNumber
            }

            val newLottoNumber = LottoNumber(number)
            lottoNumbers.add(newLottoNumber)
            return newLottoNumber
        }

        fun from(number: String): LottoNumber = from(number.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다."))
    }
}
