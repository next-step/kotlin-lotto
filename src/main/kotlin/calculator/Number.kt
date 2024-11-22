package calculator

@JvmInline
value class Number(private val value: Int) {
    init {
        require(value >= 0) { "음수를 입력할 수 없습니다 : $value" }
    }

    fun toInt() = value

    companion object {
        fun from(value: String): Number {
            val number =
                value.toIntOrNull()
                    ?: throw IllegalArgumentException("잘못된 입력값입니다 : $value")
            return Number(number)
        }
    }
}
