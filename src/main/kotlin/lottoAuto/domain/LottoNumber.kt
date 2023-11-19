package lottoAuto.domain

data class LottoNumber(val number: Int) {
    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException("로또 번호는 1~45 범위 내의 숫자여야 합니다.")
        }
    }
}

fun Int.toLottoNumber(): LottoNumber = LottoNumber.from(this)