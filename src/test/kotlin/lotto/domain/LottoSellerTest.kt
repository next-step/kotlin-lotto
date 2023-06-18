package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.util.FixedLottoGenerator

class LottoSellerTest : BehaviorSpec({
    val systemUnderTest = LottoSeller(FixedLottoGenerator)
    given("금액이 음수로 주어졌다") {
        val amount = -1
        `when`("해당 금액으로 로또를 구매하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { systemUnderTest.sellLottos(amount) }
            }
        }
    }

    given("금액이 로또 구매 금액보다 적다") {
        val amount = Lotto.LOTTO_PRICE - 1
        `when`("해당 금액으로 로또를 구매하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { systemUnderTest.sellLottos(amount) }
            }
        }
    }

    given("유효한 금액이 주어졌다") {
        val count = 14
        val amount = Lotto.LOTTO_PRICE * count
        `when`("해당 금액으로 로또를 구매하면") {
            then("로또리스트가 구매된다") {
                val lottos = systemUnderTest.sellLottos(amount)
                lottos.size shouldBe count
            }
        }
    }
})
