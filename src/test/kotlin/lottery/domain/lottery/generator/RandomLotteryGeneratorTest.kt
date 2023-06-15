package lottery.domain.lottery.generator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class RandomLotteryGeneratorTest : FunSpec({

    context("generate") {
        test("6개의 수를 반환받는다") {
            val actual = RandomLotteryGenerator.generate()
            actual.values shouldHaveSize 6
        }
    }

    context("generateLotteries") {
        test("생성 갯수를 받아 생성한다") {
            val actual = RandomLotteryGenerator.generateLotteries(count = 10)
            actual shouldHaveSize 10
        }
    }
})
