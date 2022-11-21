package lotto.domain

@JvmInline
value class WinningNumbers(private val numbers: LottoNumber = LottoNumber()) {
    fun getSumMatchingNumbers(lotto: LottoNumber): Int {
        var sum = 0
        lotto.value.forEach {
            if (isContain(it)) sum++
        }
        return sum
    }

    private fun isContain(number: Int): Boolean {
        return numbers.value.contains(number)
    }
}
