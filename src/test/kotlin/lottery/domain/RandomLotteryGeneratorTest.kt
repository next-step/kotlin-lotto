package lottery.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class RandomLotteryGeneratorTest : FunSpec({

    context("generate") {
        test("6개의 수를 반환받는다") {
            val actual = RandomLotteryGenerator.generate()
            actual shouldHaveSize 6
        }
    }
})
