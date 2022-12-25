package lotto.model

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MIN_VALUE..MAX_VALUE) { "로또 번호는 ${MIN_VALUE}~${MAX_VALUE} 사이의 숫자만 가능합니다." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}
