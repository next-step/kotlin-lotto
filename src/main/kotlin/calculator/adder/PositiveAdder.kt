package calculator.adder

import calculator.adder.value.PositiveNumber

class PositiveAdder : Adder {
    override fun sum(values: Iterable<String>): Int {
        return values.map { PositiveNumber(it) }
            .sumBy { it.value }
    }
}
