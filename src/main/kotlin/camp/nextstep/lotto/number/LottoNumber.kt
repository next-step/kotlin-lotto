package camp.nextstep.lotto.number

class LottoNumber private constructor(val value: Int) {

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45

        private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            require(value in LOTTO_NUMBER_RANGE) { "로또 번호는 ${LOTTO_NUMBER_RANGE.first}에서 ${LOTTO_NUMBER_RANGE.last} 사이의 정수입니다." }

            return requireNotNull(LOTTO_NUMBERS[value])
        }
    }
}
