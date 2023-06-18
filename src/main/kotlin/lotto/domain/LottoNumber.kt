package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) {

    init {
        require(number in 1..45) {
            "1 ~ 45 의 숫자만 가능합니다."
        }
    }
}