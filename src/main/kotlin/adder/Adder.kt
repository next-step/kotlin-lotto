package adder

import java.lang.RuntimeException

class Adder {

    fun getSum(input: String): Int {
        return getNumbers(input).sum()
    }

    private fun getNumbers(input: String): List<Int> {
        return input.split(delimiters = delimiter).map { it -> checkNumber(it) }
    }

    private fun checkNumber(input: String): Int {
        try {
            val result = input.toInt()
            if (result < 0) {
                throw RuntimeException()
            }
            return result
        } catch (e: NumberFormatException) {
            throw RuntimeException()
        }
    }

    companion object {
        private val delimiter = arrayOf(",", ":")
    }
}
