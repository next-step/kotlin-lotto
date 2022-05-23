package lotto.model.data

interface Policy {
    val rangeOfNumbers: LottoNumberRange
    val countOfNumberToSelect: Int
    val priceOfLotto: Int
    val limitAmountToPurchase: Int
        get() = Int.MAX_VALUE
    val isManualPurchaseAllowed: Boolean
        get() = true

    fun validateNumbers(numbers: Collection<LottoNumber>): IllegalArgumentException? {
        return when {
            numbers.size != countOfNumberToSelect -> IllegalArgumentException("${countOfNumberToSelect}개의 숫자가 필요합니다.")
            numbers.any { it !in rangeOfNumbers } -> IllegalArgumentException("범위를 벗어난 숫자가 있습니다.")
            else -> null
        }
    }

    fun validateWinningNumbers(numbers: Collection<LottoNumber>, bonusNumber: LottoNumber): IllegalArgumentException? {
        return validateNumbers(numbers)
            ?: if (bonusNumber !in this.rangeOfNumbers) {
                IllegalArgumentException("${bonusNumber}는 ${this.rangeOfNumbers.start}~${this.rangeOfNumbers.endInclusive} 사이 숫자가 아닙니다.")
            } else {
                null
            }
    }
}
