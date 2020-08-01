package calculator


fun hasCustomDelimeter(string: String): Boolean {
    val split = Regex("//(.*)\n").find(string)
    if (split != null && split.groupValues[1].isNotBlank()) {
        return true
    }
    return false
}

class Calculator() {
}
