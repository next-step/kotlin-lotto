package calculator

class NegativeNumberValidation : NumberValidation {
    override fun check(input: Int): Boolean = input < 0
}
