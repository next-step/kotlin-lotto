package lotto.policy

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.policy.TargetNumberAutoGenerateStrategy
import lotto.domain.vo.TargetNumber
import lotto.domain.vo.TargetNumbers

class TargetNumberAutoGenerateStrategyTest : FreeSpec({

    val wholeTargetNumbers = generateWhileTargetNumbers()

    "자동으로 추첨 번호를 생성할 수 있다" - {
        val randomTargetNumbers = TargetNumberAutoGenerateStrategy.generate()
        randomTargetNumbers.shouldNotBeNull()

        "중복되지 않는 ${TargetNumbers.TARGET_NUMBER_SIZE}개의 추첨 번호를 가지고 있다" {
            var sameNumber = 0
            wholeTargetNumbers.forEach {
                if (randomTargetNumbers.contains(it)) {
                    sameNumber++
                }
            }
            sameNumber shouldBe TargetNumbers.TARGET_NUMBER_SIZE
        }
    }
})

private fun generateWhileTargetNumbers(): Set<TargetNumber> {
    val targetNumbers = mutableSetOf<TargetNumber>()
    var initNumber = TargetNumber.MIN_NUMBER
    repeat(TargetNumber.MAX_NUMBER) { targetNumbers.add(TargetNumber(initNumber++)) }
    return targetNumbers.toSet()
}
