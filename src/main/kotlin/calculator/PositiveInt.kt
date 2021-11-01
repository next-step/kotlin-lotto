package calculator

@JvmInline
value class PositiveInt(val value: Int) {

    init {
        require(value >= 0) { "$value 은/는 양수가 아닙니다." }
    }

    constructor(value: String) : this(toInt(value))
}

private fun toInt(string: String): Int {
    return string.toIntOrNull() ?: throw RuntimeException("$string 은/는 정수가 아닙니다.")
}
