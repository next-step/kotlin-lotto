package lottoAuto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1~45 범위 내의 숫자여야 합니다." }
    }

    companion object {
        fun of(number: Int): LottoNumber {
            return LottoNumber(number)
        }
    }
}
