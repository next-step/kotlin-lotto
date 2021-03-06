package caculator

internal class Numbers(private val numbers: List<Number>) {

    fun sum(): Number {
        return this.numbers.fold(Number.ZERO) { total, num -> total + num }
    }
}
