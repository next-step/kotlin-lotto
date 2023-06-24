package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.test.FakeGenerator

class LottoWinningNumbersTest : StringSpec({
    "로또 당첨 번호는 6개여야 한다." {
        shouldNotThrowAny {
            LottoWinningNumbers(FakeGenerator.lotto(1, 2, 3, 4, 5, 6), LottoNumber(7))
        }
    }

    "로또 당첨 번호가 6개가 아니면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoWinningNumbers(FakeGenerator.lotto(1, 2, 3, 4, 5), LottoNumber(7))
        }
    }

    "로또 당첨 번호에 중복이 있으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoWinningNumbers(FakeGenerator.lotto(1, 2, 3, 4, 5, 5), LottoNumber(7))
        }
    }

    "로또 당첨 번호와 보너스볼에 중복이 있으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoWinningNumbers(FakeGenerator.lotto(1, 2, 3, 4, 5, 6), LottoNumber(6))
        }
    }

    "로또 당첨 등수를 구할 수 있다." {
        val lottoWinningNumbers = LottoWinningNumbers(FakeGenerator.lotto(1, 2, 3, 4, 5, 6), LottoNumber(20))

        listOf(
            FakeGenerator.lotto(1, 2, 3, 4, 5, 6) to LottoRank.FIRST,
            FakeGenerator.lotto(1, 2, 3, 4, 5, 20) to LottoRank.SECOND,
            FakeGenerator.lotto(1, 2, 3, 4, 5, 16) to LottoRank.THIRD,
            FakeGenerator.lotto(1, 2, 3, 4, 15, 16) to LottoRank.FOURTH,
            FakeGenerator.lotto(1, 2, 3, 14, 15, 16) to LottoRank.FIFTH,
            FakeGenerator.lotto(1, 2, 13, 14, 15, 16) to LottoRank.NONE
        ).forAll { (lotto, rank) ->
            val lottoRank = lottoWinningNumbers.getRank(lotto)
            lottoRank shouldBe rank
        }

    }
})
