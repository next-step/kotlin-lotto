package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.createLottoNumbers
import lotto.fixture.of

class WinningInfoTest : FreeSpec({
    "당첨 번호는 중복되지 않는 6개의 로또 번호를 가진다." {
        val actual = WinningInfo(
            values = createLottoNumbers(1, 2, 3, 4, 5, 6),
            bonusNumber = LottoNumber.valueOf(7)
        )

        actual.size shouldBe 6
    }

    "6개가 아닌 로또 번호를 전달하면 예외를 던진다." - {
        (1..45).filter { it != 6 }.forEach {
            "$it 개의 로또 번호를 전달하면 예외를 던진다." {
                val actual = createLottoNumbers(capacity = it)

                shouldThrow<IllegalArgumentException> {
                    WinningInfo(values = actual, bonusNumber = LottoNumber.valueOf(7))
                }
            }
        }
    }

    "로또를 전달하면 당첨 등수를 반환 한다." {
        val winningInfo =
            WinningInfo(values = createLottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber = LottoNumber.valueOf(7))

        listOf(
            Lotto.of(1, 2, 3, 4, 5, 6) to Rank.FIRST,
            Lotto.of(1, 2, 3, 4, 5, 7) to Rank.SECOND,
            Lotto.of(1, 2, 3, 4, 11, 8) to Rank.FOURTH,
            Lotto.of(1, 2, 3, 7, 8, 9) to Rank.FIVE,
            Lotto.of(1, 2, 7, 8, 9, 10) to Rank.MISS,
            Lotto.of(1, 7, 8, 9, 10, 11) to Rank.MISS
        ).forEach {
            val actual: Rank = winningInfo.matches(it.first)

            actual shouldBe it.second
        }
    }
})
