package study.calculator

class PositiveNumberValidator : Validator<List<Int>> {
    override fun validate(numbers: List<Int>) = numbers.forEach(::validatePosiveInteger)

    private fun validatePosiveInteger(number: Int) {
        if (number < ZERO) throw RuntimeException("Negatives not allowed: $number")
    }

    companion object {
        const val ZERO = 0
    }
}
