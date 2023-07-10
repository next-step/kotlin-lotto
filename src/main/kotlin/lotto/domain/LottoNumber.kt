package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        if (number !in MIN..MAX) {
            throw IllegalArgumentException("로또 번호는 1~45까지 입력 가능합니다.")
        }
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
