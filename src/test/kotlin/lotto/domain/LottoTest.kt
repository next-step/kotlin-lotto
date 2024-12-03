package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({
    "유효하지 않은 번호 개수를 입력하면 예외를 발생시킨다" - {
        listOf(
            intArrayOf(),
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
        ).forEach { numbers ->
            "입력값: $numbers" {
                shouldThrow<InvalidLottoNumberCountException> { Lotto(*numbers) }
            }
        }
    }

    "다른 Lotto를 받아, 동일한 숫자가 몇 개 있는지 계산한다" - {
        val otherLotto = Lotto(1, 2, 3, 4, 5, 6)

        mapOf(
            intArrayOf(1, 2, 3, 4, 5, 6) to 6,
            intArrayOf(1, 32, 33, 34, 35, 36) to 1,
            intArrayOf(31, 32, 33, 34, 35, 36) to 0,
        ).forEach { (lottoNumbers, expectedCount) ->
            "입력값: Lotto번호=$lottoNumbers, 일치 개수 =$expectedCount" {
                val lotto = Lotto(*lottoNumbers)
                lotto.calculateMatchCount(otherLotto) shouldBe expectedCount
            }
        }
    }
})
