package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoCheckerTest : BehaviorSpec({
    given("당첨번호가 6개가 주어지지 않았다") {
        val winNumbers = listOf(1, 2, 3, 4, 5)
        `when`("해당 당첨번호로 결과를 조회하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoChecker.checkResult(emptyList(), winNumbers) }
            }
        }
    }

    given("로또리스트와 당첨번호가 주어졌다") {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 2, 7, 8, 9, 10)),
            Lotto(listOf(1, 7, 8, 9, 10, 11))
        )
        val winNumbers = listOf(1, 2, 3, 4, 5, 6)
        `when`("당첨결과를 확인했을때") {
            then("정확한 결과가 반환된다") {
                LottoChecker.checkResult(lottos, winNumbers) shouldBe mapOf(
                    3 to 1,
                    4 to 1,
                    5 to 1,
                    6 to 1
                )
            }
        }
    }
})
