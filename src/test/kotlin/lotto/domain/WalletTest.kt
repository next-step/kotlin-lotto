package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.vo.Money

internal class WalletTest : StringSpec({

    "금액이 부족한 경우 차감시 예외를 발생한다." {
        val wallet = Wallet(Money(1000))

        val throwableAction = { wallet.withdraw(Money(5000)) }

        shouldThrow<IllegalArgumentException>(throwableAction)
    }
})
