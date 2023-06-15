package lotto.model

@JvmInline
value class LottoNumber(val number: Int) {

    init {
        require((MIN_NUMBER <= number) and (number <= MAX_NUMBER)) {
            "lottoNumber must be between $MIN_NUMBER and $MAX_NUMBER. but provided number(`$number`)"
        }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val ALL = (MIN_NUMBER..MAX_NUMBER).map(::LottoNumber).toSet()
    }
}
