package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    override fun toString(): String {
        return value.toString()
    }
}
