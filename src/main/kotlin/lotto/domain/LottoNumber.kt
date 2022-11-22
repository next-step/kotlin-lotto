package lotto.domain

data class LottoNumber(val number: Int) {
    companion object {
        private const val MIN = 0
        private const val MAX = 45
        val NUMBERS: Map<Int, LottoNumber> = (MIN..MAX).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber = NUMBERS[number] ?: throw IllegalArgumentException()
    }
}
