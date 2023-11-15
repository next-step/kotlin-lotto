package lotto.domain.model.vo

/**
 * 로또 숫자
 * */
@JvmInline
value class LottoNumber private constructor(val number: Int){

    init {
        require(number in MIN_NUMBER_VALUE..MAX_NUMBER_VALUE) {
            "로또 번호는 $MIN_NUMBER_VALUE~$MAX_NUMBER_VALUE 사이의 값으로 구성되어야 합니다."
        }
    }

    override fun toString(): String {
        return number.toString()
    }
    companion object {
        const val MIN_NUMBER_VALUE = 1
        const val MAX_NUMBER_VALUE = 45

        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER_VALUE..MAX_NUMBER_VALUE).associateWith { LottoNumber(it) }

        /**
         * 로또 숫자 객체 생성
         * */
        fun valueOf(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("로또 번호는 $MIN_NUMBER_VALUE~$MAX_NUMBER_VALUE 사이의 값으로 구성되어야 합니다.")
        }
    }
}
