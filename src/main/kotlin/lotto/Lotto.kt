package lotto

data class Lotto(val numbers: Set<Int>) {
    init {
        LottoNumberValidator.validateNumbers(numbers)
    }
}
