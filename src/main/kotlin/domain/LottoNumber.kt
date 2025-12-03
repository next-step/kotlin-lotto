package domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1~45 사이여야합니다." }
    }
}
