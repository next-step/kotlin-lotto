package lotto.domain

class LottoNumber private constructor(
    private val lottoNumber: Int = 0
) {
    var number = lottoNumber
        private set

    companion object {
        private const val MINIMUM_LOTTO_NUMBER: Int = 1
        private const val MAXIMUM_LOTTO_NUMBER: Int = 45
        private val LOTTO_NUMBERS: Map<Int, LottoNumber> =
            (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).associateWith(::LottoNumber)

        fun from(number: Int) = LOTTO_NUMBERS[number]
            ?: throw IllegalArgumentException("로또 번호는 1~45 사이의 양의 정수만 구성할 수 있습니다. 사용된 숫자 :${number}")
    }
}
