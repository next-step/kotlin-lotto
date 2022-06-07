package lotto

@JvmInline
value class LottoNumber(private val value: Int) {

    init {
        require(this.value in 1..45) { "로또 번호는 1이상 45이하의 숫자여야 합니다." }
    }
}
