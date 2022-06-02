package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { ERROR_LOTTO_NUMBER_RANGE }
    }

    operator fun rangeTo(end: LottoNumber): IntRange = this.number..end.number

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        private const val ERROR_LOTTO_NUMBER_RANGE = "로또숫자는 $MIN_NUMBER ~ $MAX_NUMBER 사이의 값을 갖는다"
    }
}
