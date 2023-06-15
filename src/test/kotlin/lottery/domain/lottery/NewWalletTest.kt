package lottery.domain.lottery

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lottery.domain.Money
import lottery.domain.lottery.generator.RandomLotteryGenerator

class NewWalletTest : FunSpec({

    context("buyLottery") {
        test("로또를 구매할 수 없는 경우 예외가 발생한다.") {
            val wallet = NewWallet(money = Money(999))
            val exception =
                shouldThrowExactly<IllegalStateException> { wallet.buyLotteries(RandomLotteryGenerator) }
            exception.message shouldBe "로또를 사기엔 부족한 금액이다"
        }
    }
})
