package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value >= 1) { "로또 숫자는 1 이상이어야 합니다" }
        require(value <= 45) { "로또 숫자는 45 이하여야 합니다" }
    }
}
