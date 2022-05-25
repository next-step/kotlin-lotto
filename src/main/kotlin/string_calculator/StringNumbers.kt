package string_calculator

class StringNumbers(
    private val stringNumbers: List<StringNumber>,
) {
    val size: Int
        get() = stringNumbers.size

    fun addAll(): StringNumber {
        return stringNumbers.fold(StringNumber.ZERO) { acc, stringNumber ->
            acc + stringNumber
        }
    }
}
