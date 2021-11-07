package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    init {
        verify()
    }

    private fun verify() {
        require(value in MIN_VALUE..MAX_VALUE) { "1에서 45사이의 값만 선택할 수 있습니다." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45

        fun of(value: Int): LottoNumber {
            return LottoNumber(value)
        }
    }
}
