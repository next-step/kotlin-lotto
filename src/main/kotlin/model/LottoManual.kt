package model

class LottoManual(val value: Int) {
    constructor(value: String) : this(value.toInt())
    init {
        if (!Number.NUMBER_REGEX.matches(value.toString())) {
            throw IllegalArgumentException("only input number")
        }
    }
}
