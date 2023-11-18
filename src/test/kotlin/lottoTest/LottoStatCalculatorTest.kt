package lottoTest

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.LottoStatCalculator
import lotto.domain.LottoStatResult
import lotto.domain.PurchasedLottery
import lotto.domain.Rank
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertEquals

data class LottoStatCalculatorTestData(
    val winningLotto: WinningLotto,
    val purchasedLottery: PurchasedLottery,
    val expected: LottoStatResult,
)

class LottoStatCalculatorTest : FunSpec({
    context("당첨 통계 계산") {
        withData(
            listOf(
                LottoStatCalculatorTestData(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    PurchasedLottery(
                        manualLottery = Lottery(
                            listOf(
                                Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                            )
                        ),
                        autoLottery = Lottery(
                            listOf(
                                Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                            )
                        ),
                    ),
                    LottoStatResult(
                        mapOf(
                            Pair(Rank.FIRST, 0),
                            Pair(Rank.SECOND, 0),
                            Pair(Rank.THIRD, 0),
                            Pair(Rank.FOURTH, 0),
                            Pair(Rank.FIFTH, 2),
                            Pair(Rank.MISS, 0),
                        )
                    )
                ),
                LottoStatCalculatorTestData(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    PurchasedLottery(
                        manualLottery = Lottery(
                            listOf(
                                Lotto(numbers = listOf(1, 2, 3, 4, 5, 45)),
                            )
                        ),
                        autoLottery = Lottery(
                            listOf(
                                Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                            )
                        ),
                    ),
                    LottoStatResult(
                        mapOf(
                            Pair(Rank.FIRST, 0),
                            Pair(Rank.SECOND, 1),
                            Pair(Rank.THIRD, 0),
                            Pair(Rank.FOURTH, 0),
                            Pair(Rank.FIFTH, 1),
                            Pair(Rank.MISS, 0),
                        )
                    )
                )
            )
        ) { (winningLotto, purchasedLottery, expected) ->
            val result = LottoStatCalculator(winningLotto).getStat(purchasedLottery.getLottery())

            Rank.values().forEach {
                assertEquals(expected.getCount(it), result.getCount(it))
            }
        }
    }
})
