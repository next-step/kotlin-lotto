package lotto.domain

data class LottoNumber(
    val number: Int
) {
    init {
        require(number in (MIN..MAX))
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}