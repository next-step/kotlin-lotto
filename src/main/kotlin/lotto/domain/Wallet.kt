package lotto.domain

import lotto.vo.Money

class Wallet(private var money: Money) {

    fun withdraw(money: Money) {
        require(this.money.isGreaterOrEqualThan(money)) { "금액이 부족합니다." }
        this.money -= money
    }
}
