package lotto

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1~45 범위만 가진다." }
    }
}
