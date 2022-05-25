package calculator

@JvmInline
value class PositiveNumber(val number: Int) {

    init {
        checkValidation()
    }

    private fun checkValidation() {
        if (number < 0) throw RuntimeException()
    }

    companion object {
        fun of(source: Int): PositiveNumber = PositiveNumber(source)
    }
}

// Extensions
fun Int.toPositiveNumber(): PositiveNumber = PositiveNumber.of(this)
fun String.toPositiveNumber(): PositiveNumber = toInt().toPositiveNumber()
