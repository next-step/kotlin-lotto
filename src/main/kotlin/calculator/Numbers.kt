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
        require(values.all { it >= 0 }) { "음수가 존재합니다." }
    }
}