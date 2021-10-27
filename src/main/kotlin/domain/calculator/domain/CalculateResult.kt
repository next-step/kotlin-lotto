package domain.calculator.domain

@JvmInline
value class CalculateResult(val result: Int) {
    init {
        if (result < MINIMUM) throw RuntimeException("")
    }

    companion object {
        private const val MINIMUM = 0;
    }
}
