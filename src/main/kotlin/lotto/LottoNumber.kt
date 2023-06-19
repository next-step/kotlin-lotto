package lotto

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(number in 1..45) { "로또 번호는 1과 45 사이의 값만 가능합니다" }
    }
}
