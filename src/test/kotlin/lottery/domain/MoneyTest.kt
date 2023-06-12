package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.generator.RandomLotteryGenerator
import java.math.BigDecimal

class MoneyTest : FunSpec({

    context("init") {
        test("돈은 음수가 입력될 경우 예외가 발생한다") {
            val exception = shouldThrowExactly<IllegalArgumentException> { Money(value = -1) }
            exception.message shouldBe "돈은 음수가 입력될 수 없다"
        }
    }

    context("purchaseLotteries") {
        test("로또를 사기에 부족한 돈이 입력될 경우 예외가 발생한다") {
            val exception = shouldThrowExactly<IllegalStateException> { Money(value = 999).purchaseLotteries(
                RandomLotteryGenerator
            ) }
            exception.message shouldBe "로또를 사기엔 부족한 금액이다"
        }

        test("금액만큼 로또를 구매할 수 있다") {
            val actual = Money(value = 2_500).purchaseLotteries(RandomLotteryGenerator)
            actual.usedMoney shouldBe BigDecimal(2_000)
            actual.purchasedLotteries shouldHaveSize 2
        }
    }
})
