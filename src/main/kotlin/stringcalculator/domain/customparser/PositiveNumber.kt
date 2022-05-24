package stringcalculator.domain.customparser

@JvmInline
value class PositiveNumber(val value: Int) {
    init {
        validateNumberForIncludeNegativeNumber(value)
    }

    companion object {
        private fun validateNumberForIncludeNegativeNumber(positiveInt: Int) {
            require(positiveInt >= 0) { getErrorMessageIncludeNegativeNumber(positiveInt) }
        }

        private fun getErrorMessageIncludeNegativeNumber(negativeNumber: Int): String {
            return "음수($negativeNumber)은 입력할수 없습니다"
        }
    }
}
