package stringaddcalculator.domain

class StringNumber(text: String) {
    val value: Int

    init {
        this.value = text.toIntOrNull() ?: throw RuntimeException("숫자가 아닌 값을 입력할 수 없습니다.")
        validateNegativeNumber(this.value)
    }

    private fun validateNegativeNumber(number: Int) {
        if (number < MINIMUM_NUMBER) {
            throw RuntimeException("{$MINIMUM_NUMBER}보다 작은 값을 입력할 수 없습니다.")
        }
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
    }
}
