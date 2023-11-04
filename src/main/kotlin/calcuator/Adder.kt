package calcuator

object Adder {

    fun sum(numbers: List<AddOperand>): Int =
        numbers.sumOf { it.value }
}
