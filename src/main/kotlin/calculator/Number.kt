package calculator

data class Number(val value: Int) {
    companion object {
        val ZERO = Number(0).value
    }
}
