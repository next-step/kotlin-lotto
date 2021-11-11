package calculator

class Calculator {
    fun add(value: String?): Int {
        if (value.isNullOrBlank()) return 0
        if (value.toIntOrNull() != null) return value.toInt()
        val values = value.split(",").map { it.toInt() }
        return values.sum()
    }
}

