package calculator

data class PositiveNumber(val value: Long) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    companion object {
        fun fromString(value: String): PositiveNumber {
            require(value.toLongOrNull() != null) { "숫자가 아닙니다. [$value]" }
            return PositiveNumber(value.toLong())
        }
    }
}
