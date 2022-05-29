package lotto.view

import lotto.domain.Money

class MoneyView(private val io: IO) {

    fun readMoney(): Money {
        io.print("구입금액을 입력해 주세요.")

        return read()
    }

    private tailrec fun read(): Money = runCatching {
        val value = io.read().toIntOrNull()

        requireNotNull(value) { "숫자만 입력해 주세요." }

        Money(value)
    }.getOrElse {
        io.print(it.message ?: "잘못 입력하셨습니다.")

        return read()
    }
}
