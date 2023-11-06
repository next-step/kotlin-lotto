package calculator

class Number(private val num: String) {
    val value: Int
        get() = num.toInt()
    val isPositiveOrZero: Boolean
        get() = value >= 0

    init {
        require(num.matches(Regex("-?\\d+"))) { "${num}는 숫자여야합니다." }
    }
}
