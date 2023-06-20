package calculator

class Numbers(
    private val values: List<Int>
) {
    init {
        validateNumbers()
    }

    fun sum(): Int {
        return values.sum()
    }

    private fun validateNumbers() {
        if (values.any { it < 0 }) {
            throw IllegalArgumentException("음수가 존재합니다.")
        }
    }
}