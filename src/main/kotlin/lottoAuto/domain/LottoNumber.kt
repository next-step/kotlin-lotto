package lottoAuto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 1~45 범위 내의 숫자여야 합니다." }
    }

    companion object {
        fun of(number: Int): LottoNumber {
            return LottoNumber(number)
        }

        fun ofRandom(): LottoNumber {
            return LottoNumber((MIN_NUMBER..MAX_NUMBER).random())
        }

        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
