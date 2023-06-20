package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottosTest : DescribeSpec({

    describe("Lottos method") {
        context("Lottos size()를 호출하면") {
            it("Lotto 개수를 제공") {
                Lottos.of(setOf(Lotto.from(setOf(1, 2, 3, 4, 5, 6)), Lotto.from(setOf(2, 3, 4, 5, 6, 7))))
                    .size() shouldBe 2
            }
        }

        context("Lottos numbers()를 호출하면") {
            it("Lotto 숫자들을 Int Set으로 제공") {
                Lottos.of(setOf(Lotto.from(setOf(1, 2, 3, 4, 5, 6)), Lotto.from(setOf(2, 3, 4, 5, 6, 7))))
                    .numbers() shouldBe setOf(setOf(1, 2, 3, 4, 5, 6), setOf(2, 3, 4, 5, 6, 7))
            }
        }
    }
})
