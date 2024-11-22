package lotto

data class WinNumbers(val numbers: Set<Int>) {
    init {
        LottoNumberValidator.validateNumbers(numbers)
    }

    fun countMatchingNumbers(lottoNumbers: Set<Int>): Int {
        return lottoNumbers.count { it in numbers }
    }
}
