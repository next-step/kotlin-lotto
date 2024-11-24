package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import lotto.infrastructure.DefaultProfitRateCalculator

class LottoLinesTest : StringSpec({
    "입력 받은 로또 라인의 수가 0이면 예외 처리한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> { LottoLines(listOf()) }
        exception.message shouldBe "1개 이상의 로또 라인을 가지고 있어야 합니다."
    }

    "당첨 번호와 비교해 게임 결과를 반환할 수 있다." {
        forAll(
            row(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 7),
                    listOf(1, 2, 3, 4, 7, 8),
                    listOf(1, 2, 3, 7, 8, 9),
                    listOf(1, 2, 7, 8, 9, 10),
                    listOf(1, 7, 8, 9, 10, 11),
                    listOf(7, 8, 9, 10, 11, 12),
                ),
                listOf(1, 2, 3, 4, 5, 6),
                mapOf(
                    LottoRank.FIRST to 1,
                    LottoRank.SECOND to 1,
                    LottoRank.THIRD to 1,
                    LottoRank.FOURTH to 1,
                    LottoRank.NO_RANK to 3,
                ),
            ),
        ) { lottoNumbers, winningNumbers, expected ->
            val lottoLines = LottoLines(lottoNumbers.map { LottoLine(it.map { LottoBall(it) }.toList()) })
            lottoLines.extractLottoGameResult(
                WinningLotto(
                    LottoLine(
                        winningNumbers.map { LottoBall(it) }
                            .toList(),
                    ),
                    LottoBall(7),
                ),
                DefaultProfitRateCalculator(),
            ) shouldBeEqualToComparingFields LottoGameResult(expected, DefaultProfitRateCalculator())
        }
    }
})
