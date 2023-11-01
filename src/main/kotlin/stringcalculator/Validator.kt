package stringcalculator

class Validator {

    fun areAllPositiveNumbers(input: List<String>): Boolean {
        return input.all { it.toIntOrNull() ?: -1 > 0 }
    }
}
