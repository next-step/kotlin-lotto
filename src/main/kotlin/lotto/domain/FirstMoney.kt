package lotto.domain

class FirstMoney(val firstMoney: Int) : Money(firstMoney) {
    init {
        require(money >= LOTTO_PRICE) {
            "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다."
        }
    }
}
