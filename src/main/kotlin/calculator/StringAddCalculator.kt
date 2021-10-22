package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        require(!text.isNullOrBlank()) { return 0 }
        return text.toInt()
    }
}
