package lottery.domain

class Money(
    val value: Int
) {
    init {
        require(value >= 0) { "돈은 음수가 입력될 수 없다" }
    }

    fun purchaseLotteries() {
        check(value >= 1_000) { "로또를 사기엔 부족한 금액이다" }
    }
}
