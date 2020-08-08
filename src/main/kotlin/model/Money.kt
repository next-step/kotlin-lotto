package model

data class Money(val value: String?) {
    init {
        checkNotNull(value)
        if (!NUMBER_REGEX.matches(value)) {
            throw IllegalArgumentException("not acceptd not number value")
        }
    }

    companion object {
        val NUMBER_REGEX = Regex(pattern = "^?[0-9]\\d*(\\.\\d+)?\$")
    }
}
