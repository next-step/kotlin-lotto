package lottery

class Money(
    val value: Int
) {
    init {
        require(value >= 0) { "돈은 음수가 입력될 수 없다" }
    }
}
