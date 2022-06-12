package lotto.dto

import lotto.domain.Money

class UserMoneyInputDto(moneyByString: String) {
    val userMoney: Money

    init {
        val moneyByInt =
            moneyByString.replace(" ", "").toLongOrNull() ?: throw IllegalArgumentException("금액은 숫자를 입력해주세요")
        userMoney = Money(moneyByInt)
    }
}
