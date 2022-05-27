package lotto.auto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.auto.vo.LottoScore

internal class LottoTest : BehaviorSpec({

    given("로또의 번호가") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        var lastWeekLotto = Lotto(listOf(1, 7, 8, 9, 10, 11))
        `when`("1개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("꽝") {
                result shouldBe LottoScore.BANG
            }
        }

        lastWeekLotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        `when`("2개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("꽝") {
                result shouldBe LottoScore.BANG
            }
        }

        lastWeekLotto = Lotto(listOf(1, 2, 3, 9, 10, 11))
        `when`("3개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("4등") {
                result shouldBe LottoScore.FOUR_PLACE
            }
        }

        lastWeekLotto = Lotto(listOf(1, 2, 3, 4, 10, 11))
        `when`("4개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("3등") {
                result shouldBe LottoScore.THIRD_PLACE
            }
        }

        lastWeekLotto = Lotto(listOf(1, 2, 3, 4, 5, 11))
        `when`("5개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("2등") {
                result shouldBe LottoScore.TWO_PLACE
            }
        }

        lastWeekLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        `when`("6개 맞을 경우") {
            val result = lotto.match(lastWeekLotto)
            then("1등") {
                result shouldBe LottoScore.ONE_PLACE
            }
        }
    }

    given("로또 생성시") {
        `when`("중복된 숫자가 포함된 경우") {
            val throwableAction = {
                Lotto(listOf(1, 1, 2, 3, 4, 5))
            }
            then("IllegalArgumentException 예외를 던진다.") {
                shouldThrow<IllegalArgumentException>(throwableAction)
            }
        }

        `when`("6개의 번호가 아닌 경우") {
            then("IllegalArgumentException 예외를 던진다.")
        }

        `when`("1~45 범위 외의 숫자가 포함된 경우") {
            then("IllegalArgumentException 예외를 던진다.")
        }
    }
})
