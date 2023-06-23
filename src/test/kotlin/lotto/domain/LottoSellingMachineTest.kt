package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.util.FixedLottoGenerator

class LottoSellingMachineTest : BehaviorSpec({

    given("구매 금액으로 구매 가능한 로또 개수보다 더 많은 로또 구매 희망 개수가 주어졌다") {
        val count = 14
        val amount = Lotto.LOTTO_PRICE * (count - 1)
        `when`("해당 금액과 개수로 로또를 구매하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> {
                    LottoSellingMachine.sellLottos(
                        amount,
                        FixedLottoGenerator,
                        count
                    )
                }
            }
        }
    }

    given("구매 금액으로 구매 가능한 로또 개수보다 더 적은 로또 구매 희망 개수가 주어졌다") {
        val count = 14
        val amount = Lotto.LOTTO_PRICE * (count + 1)
        `when`("해당 금액과 개수로 로또를 구매하면") {
            then("희망하는 로또 구매 개수만큼 구매된다") {
                val lottoSellResult = LottoSellingMachine.sellLottos(amount, FixedLottoGenerator, count)
                lottoSellResult.lottos.size shouldBe count
            }
        }
    }

    given("유효한 금액만 주어졌다") {
        val count = 14
        val amount = Lotto.LOTTO_PRICE * count
        `when`("해당 금액으로 로또를 구매하면") {
            then("가능한 만큼 전부 구매된다") {
                val lottoSellResult = LottoSellingMachine.sellLottos(amount, FixedLottoGenerator)
                lottoSellResult.lottos.size shouldBe count
            }
        }
    }
})
