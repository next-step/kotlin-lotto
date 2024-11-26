package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    "보너스 번호는 당첨 번호와 중복될 수 없다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), 6),
            row(listOf(7, 8, 9, 10, 11, 12), 12),
        ) { winningNumbers, bonusNumber ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    WinningLotto.makeWinningLotto(
                        LottoBalls(winningNumbers.map { LottoBall(it) }),
                        LottoBall(bonusNumber),
                    )
                }
            exception.message shouldBe "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        }
    }

    "다른 로또 라인과 비교해 일치하는 번호의 개수와 보너스 번호 일치 여부를 반환할 수 있다." {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                7,
                listOf(1, 2, 3, 4, 5, 6),
                Pair(6, false),
            ),
            row(
                listOf(1, 2, 3, 4, 5, 6),
                7,
                listOf(1, 2, 3, 4, 5, 7),
                Pair(6, true),
            ),
            row(
                listOf(1, 2, 3, 4, 5, 6),
                7,
                listOf(7, 8, 9, 10, 11, 12),
                Pair(1, true),
            ),
        ) { winningNumbers, bonusNumber, playerNumbers, expected ->
            val winningLotto =
                WinningLotto.makeWinningLotto(
                    LottoBalls(winningNumbers.map { LottoBall(it) }),
                    LottoBall(bonusNumber),
                )
            val playerLottoLine = LottoLine(playerNumbers.map { LottoBall(it) })

            winningLotto.match(playerLottoLine) shouldBe expected
        }
    }
})
