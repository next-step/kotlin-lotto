package lotto.view

import lotto.domain.Money

class MoneyView(private val io: IO) {

    fun readMoney(): Money {
        io.print("구입금액을 입력해 주세요.")

        return read()
    }

    private tailrec fun read(): Money {
        io.read().toIntOrNull()?.let {
            return Money(it)
        }
        io.print("숫자만 입력해 주세요.")

        return read()
    }
}
