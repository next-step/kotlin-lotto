package calculator.domain

interface StringReadStrategy {
    fun readString(string: String): List<String>
}
