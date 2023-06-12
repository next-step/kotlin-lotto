package lottery

@JvmInline
value class LotteryNumber(
    val value: Int
) {
    init {
        require(value in 1..45) { "로또 번호는 1~45의 수만 입력 가능하다." }
    }
}
