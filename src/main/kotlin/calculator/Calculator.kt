package calculator

class Calculator {
    fun add(value: String?): Int {
        if (value.isNullOrBlank()) return 0
        if (value.toIntOrNull() != null) return value.toInt()
        return 0
    }
}

