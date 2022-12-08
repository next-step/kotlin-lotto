package lotto.domain

class Payment(
    val payment: Int
) {
    init {
        require(payment >= 0) { "지불액은 음수가 될 수 없습니다." }
    }
}
