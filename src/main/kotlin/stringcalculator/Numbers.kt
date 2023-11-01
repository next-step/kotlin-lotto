package stringcalculator

@JvmInline
value class Numbers(private val numbers: List<Number>) {

    fun sum(): Number {
        return Number(numbers.sumOf { it.value })
    }
}
