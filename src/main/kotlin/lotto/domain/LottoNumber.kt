package lotto.domain

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(number in 1..45) { "1~45의 수만 가능합니다" }
    }
}

fun Int.toLottoNumber() = LottoNumber(this)
