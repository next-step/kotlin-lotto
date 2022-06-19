package stringcalculator.domain

class Calculator {
    fun add(text: String): Int =
        if (text.isEmpty()) 0 else Expression(text).numbers.sum()
}
