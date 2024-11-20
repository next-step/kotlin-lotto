package calculate

data class PositiveNumber(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    constructor(str: String) : this(str.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다"))

    companion object {
        val ZERO: PositiveNumber = PositiveNumber(0)
    }
}
