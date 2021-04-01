package lotto.domain

class LottoNumberFactory {
    companion object {
        private const val DELIMITERS = ","

        fun create(numbers: String): List<LottoNumber> {
            return numbers.split(DELIMITERS).map { LottoNumber(it.trim()) }
        }
    }
}
