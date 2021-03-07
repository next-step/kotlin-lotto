package caculator

internal data class Numbers(private val numbers: List<Number>) {

    internal fun sum(): Int {
        return this.numbers.fold(Number.ZERO) { total, num -> total + num }.value
    }
}
