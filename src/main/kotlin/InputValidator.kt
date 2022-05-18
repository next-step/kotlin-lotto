class InputValidator {
    fun checkNatualAndZero(input: String) {
        require(input.toInt() >= 0)
    }
}
