package lotto.domain

@JvmInline
value class LottoNumber(val num: Int) {
    init {
        require(num in 1..45) { "로또의 숫자는 1~45의 숫자만 가능합니다." }
    }
}