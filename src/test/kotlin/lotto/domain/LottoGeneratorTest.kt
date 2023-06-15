package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    given("금액이 음수로 주어졌다") {
        val amount = -1
        `when`("해당 금액으로 로또를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoGenerator.generateLottos(amount) }
            }
        }
    }

    given("금액이 로또 구매 금액보다 적다") {
        val amount = Lotto.LOTTO_PRICE - 1
        `when`("해당 금액으로 로또를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoGenerator.generateLottos(amount) }
            }
        }
    }

    given("유효한 금액이 주어졌다") {
        val count = 14
        val amount = Lotto.LOTTO_PRICE * count
        `when`("해당 금액으로 로또를 생성하면") {
            then("로또리스트가 생성된다") {
                val lottos = LottoGenerator.generateLottos(amount)
                lottos.size shouldBe count
            }
        }
    }

    given("주어진 조건이 없어도") {
        `when`("로또를 생성하면") {
            then("정상적으로 로또가 생성된다") {
                val lotto = LottoGenerator.generateLotto()
                lotto.numbers.distinct().count() shouldBe Lotto.LOTTO_NUMBER_SIZE
            }
        }
    }
})
