package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.lottery.Lottery
import lotto.domain.lottery.LottoNumber

class LotteryTest : StringSpec({
    "로또 길이는 6 자리이다" {
        shouldNotThrowAnyUnit {
            Lottery(LottoNumber(setOf(1, 2, 3, 4, 5, 6)))
        }
    }

    "로또 길이가 6 자리 아닐 경우" {
        shouldThrow<IllegalArgumentException> {
            Lottery(LottoNumber(setOf(1, 2, 3, 4, 5, 6, 7)))
        }.shouldHaveMessage("로또는 6자리입니다.")
    }

    "로또의 숫자가 1이상 45 이하인 경우" {
        shouldNotThrowAnyUnit {
            Lottery(LottoNumber(setOf(1, 45, 44, 2, 43, 3)))
        }
    }

    "로또의 숫자가 1이상 45 이하가 아닌 경우" {
        shouldThrow<IllegalArgumentException> {
            Lottery(LottoNumber(setOf(1, 46, 44, 2, 43, 3)))
        }.shouldHaveMessage("로또의 숫자는 1~45 사이의 정수가 가능합니다.")
    }

    "로또 intersect 테스트" {
        val lottery1 = Lottery(LottoNumber(setOf(1, 2, 3, 4, 5, 6)))
        val lottery2 = Lottery(LottoNumber(setOf(1, 2, 3, 4, 5, 7)))
        val expect = LottoNumber(setOf(1, 2, 3, 4, 5))

        val result = lottery1 intersect lottery2
        result shouldBe expect
    }
})
