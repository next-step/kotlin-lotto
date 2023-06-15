package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    given("금액을 음수로 주어졌다") {
        val amount = -1
        `when`("해당 금액으로 로또를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoGenerator.generateLottos(amount) }
            }
        }
    }

    given("유효한 금액이 주어졌다") {
        val amount = 14000
        `when`("해당 금액으로 로또를 생성하면") {
            then("로또리스트가 생성된다") {
                val lottos = LottoGenerator.generateLottos(amount)
                lottos.size shouldBe 14
            }
        }
    }
})
