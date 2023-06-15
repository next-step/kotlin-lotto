package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoCheckerTest : BehaviorSpec({
    given("당첨번호가 ${Lotto.LOTTO_NUMBER_SIZE}개가 주어지지 않았다") {
        val winNumbers = (Lotto.LOTTO_MIN_NUMBER until Lotto.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toList()
        `when`("해당 당첨번호로 결과를 조회하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoChecker.checkResult(emptyList(), winNumbers) }
            }
        }
    }

    given("로또 번호의 하한선 보다 작은 숫자가 주어졌다") {
        val winNumbers =
            (Lotto.LOTTO_MIN_NUMBER - 1 until Lotto.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE - 1).toList()
        `when`("해당 당첨번호로 결과를 조회하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoChecker.checkResult(emptyList(), winNumbers) }
            }
        }
    }

    given("로또 번호의 상한선 보다 큰 숫자가 주어졌다") {
        val winNumbers =
            (Lotto.LOTTO_MAX_NUMBER - Lotto.LOTTO_NUMBER_SIZE + 1 until Lotto.LOTTO_MAX_NUMBER + 1).toList()
        `when`("해당 당첨번호로 결과를 조회하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoChecker.checkResult(emptyList(), winNumbers) }
            }
        }
    }

    given("로또리스트와 당첨번호가 주어졌다") {
        val lottos = listOf(
            Lotto((Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER).toList()),
            Lotto((Lotto.LOTTO_MIN_NUMBER + 1..Lotto.LOTTO_MAX_NUMBER + 1).toList()),
            Lotto((Lotto.LOTTO_MIN_NUMBER + 2..Lotto.LOTTO_MAX_NUMBER + 2).toList()),
            Lotto((Lotto.LOTTO_MIN_NUMBER + 3..Lotto.LOTTO_MAX_NUMBER + 3).toList()),
            Lotto((Lotto.LOTTO_MIN_NUMBER + 4..Lotto.LOTTO_MAX_NUMBER + 4).toList()),
        )
        val winNumbers = (Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER).toList()
        `when`("당첨결과를 확인했을때") {
            then("정확한 결과가 반환된다") {
                LottoChecker.checkResult(lottos, winNumbers) shouldBe mapOf(
                    Lotto.WinningPrize.THREE to 1,
                    Lotto.WinningPrize.FOUR to 1,
                    Lotto.WinningPrize.FIVE to 1,
                    Lotto.WinningPrize.SIX to 1
                )
            }
        }
    }
})
