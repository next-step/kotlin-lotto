package calcuator

object StringAddCalculator {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return 0
        val operands = Splitter.split(input).map { AddOperand.of(it) }
        return Adder.sum(operands)
    }
}
