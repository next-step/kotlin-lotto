package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int  = StringNumbers(text).list.sumOf { it }

}
