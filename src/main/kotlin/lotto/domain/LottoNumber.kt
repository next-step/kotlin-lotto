package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in MIN_VALUE..MAX_VALUE) { "숫자는 1에서 45 사이여야 합니다." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}
