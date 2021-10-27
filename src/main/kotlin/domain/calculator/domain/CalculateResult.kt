package domain.calculator.domain

class CalculateResult(val result: Int) {
    init {
        if (result < MINIMUM) throw RuntimeException("")
    }

    companion object {
        private const val MINIMUM = 0;
    }
}