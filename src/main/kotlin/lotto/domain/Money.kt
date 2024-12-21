package lotto.domain

class Money(money: String) {
    val amount: Int = money.toIntOrNull() ?: throw IllegalArgumentException("구입 금액이 유효하지 않습니다. 숫자를 입력해주세요")
}
