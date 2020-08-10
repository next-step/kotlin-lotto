package model

data class Money(private var _value: Int) {
    val value: Int get() = _value

    constructor(value: String?) : this(value!!.toInt()) {
        if (!NUMBER_REGEX.matches(value)) {
            throw IllegalArgumentException("not acceptd not number value")
        }
        this._value = value.toInt()
    }

    companion object {
        val NUMBER_REGEX = Regex(pattern = "^?[0-9]\\d*(\\.\\d+)?\$")
    }
}
