package lotto.presentation

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Lottos
import lotto.domain.model.Price
import lotto.usecase.LottoGenerator
import lotto.usecase.LottoMachine
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameTest {

    private val lottoGame = LottoGame(
        lottoMachine = LottoMachine(LottoGenerator()),
        winningsChecker = WinningsChecker(),
        calculator = PurchaseAmountCalculator(),
    )

    @Test
    fun `자동으로만 5개 구매요청 했을 시 자동 5장, 수동 0장 구매`() {
        val lottos = lottoGame.buy(
            availablePurchaseCount = 5,
            passivityLottoNumbers = emptyList(),
        )

        assertEquals(5, lottos.getAutomaticLottoSize())
        assertEquals(0, lottos.getPassivityLottoSize())
    }

    @Test
    fun `수동으로만 5개 구매요청 했을 시 수동 5장, 자동 0장 구매`() {
        val lottos = lottoGame.buy(
            availablePurchaseCount = 5,
            passivityLottoNumbers = listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6)
            ),
        )

        assertEquals(0, lottos.getAutomaticLottoSize())
        assertEquals(5, lottos.getPassivityLottoSize())
    }

    @Test
    fun `총 구매요청 5장, 수동2장 구매요청 했을 시 수동 2장, 자동 3장 구매`() {
        val lottos = lottoGame.buy(
            availablePurchaseCount = 5,
            passivityLottoNumbers = listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6),
            ),
        )

        assertEquals(3, lottos.getAutomaticLottoSize())
        assertEquals(2, lottos.getPassivityLottoSize())
    }

    @Test
    fun `1등 당첨됐다면 1등 size 1, 수익률 2_000_000배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(1, statistics.getCountByRank(Rank.FIRST))
        assertEquals(0, statistics.getCountByRank(Rank.SECOND))
        assertEquals(0, statistics.getCountByRank(Rank.THIRD))
        assertEquals(0, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(0, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(0, statistics.getCountByRank(Rank.BLANK))
        assertEquals(2_000_000.0, statistics.getYield())
    }

    @Test
    fun `2등 당첨됐다면 2등 size 1, 수익률 30_000 배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(7),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(0, statistics.getCountByRank(Rank.FIRST))
        assertEquals(1, statistics.getCountByRank(Rank.SECOND))
        assertEquals(0, statistics.getCountByRank(Rank.THIRD))
        assertEquals(0, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(0, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(0, statistics.getCountByRank(Rank.BLANK))
        assertEquals(30_000.0, statistics.getYield())
    }

    @Test
    fun `3등 당첨됐다면 3등 size 1, 수익률 1_500 배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(8),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(0, statistics.getCountByRank(Rank.FIRST))
        assertEquals(0, statistics.getCountByRank(Rank.SECOND))
        assertEquals(1, statistics.getCountByRank(Rank.THIRD))
        assertEquals(0, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(0, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(0, statistics.getCountByRank(Rank.BLANK))
        assertEquals(1_500.0, statistics.getYield())
    }

    @Test
    fun `4등 당첨됐다면 4등 size 1, 수익률 50 배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(9),
                        LottoNumber(8),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(0, statistics.getCountByRank(Rank.FIRST))
        assertEquals(0, statistics.getCountByRank(Rank.SECOND))
        assertEquals(0, statistics.getCountByRank(Rank.THIRD))
        assertEquals(1, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(0, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(0, statistics.getCountByRank(Rank.BLANK))
        assertEquals(50.0, statistics.getYield())
    }

    @Test
    fun `5등 당첨됐다면 5등 size 1, 수익률 5 배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(10),
                        LottoNumber(9),
                        LottoNumber(8),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(0, statistics.getCountByRank(Rank.FIRST))
        assertEquals(0, statistics.getCountByRank(Rank.SECOND))
        assertEquals(0, statistics.getCountByRank(Rank.THIRD))
        assertEquals(0, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(1, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(0, statistics.getCountByRank(Rank.BLANK))
        assertEquals(5.0, statistics.getYield())
    }

    @Test
    fun `전부 당첨되지 않았다면 꽝 size 1개, 수익률 0배`() {
        val automaticLottos = listOf(
            Lotto(
                numbers = LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(11),
                        LottoNumber(10),
                        LottoNumber(9),
                        LottoNumber(8),
                    )
                ),
                price = Price(1000),
            )
        )

        val statistics = lottoGame.statistics(
            winningNumbers = listOf(1, 2, 3, 4, 5, 6),
            lottos = Lottos(
                automaticLottos = automaticLottos,
            ),
            bonusNumber = 7,
        )

        assertEquals(0, statistics.getCountByRank(Rank.FIRST))
        assertEquals(0, statistics.getCountByRank(Rank.SECOND))
        assertEquals(0, statistics.getCountByRank(Rank.THIRD))
        assertEquals(0, statistics.getCountByRank(Rank.FOURTH))
        assertEquals(0, statistics.getCountByRank(Rank.FIFTH))
        assertEquals(1, statistics.getCountByRank(Rank.BLANK))
        assertEquals(0.0, statistics.getYield())
    }
}
