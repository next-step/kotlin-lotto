package domain

class Calculator {
    fun add(text: String): Int =
        when (text.isEmpty()) {
            true -> 0
            false -> Expression(text).numbers.reduce { acc, number -> acc + number }
        }
}