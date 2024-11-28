package lotto.application

import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.Rank
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoServiceTest {
    private lateinit var sut: LottoService

    @BeforeAll
    fun setUp() {
        sut = LottoService(RandomLottoLineGenerator())
    }

    @Test
    fun `로또를 구매할 금액이 없으면 예외를 던진다`() {
        val command =
            BuyLottoCommand(
                1000L,
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7, 8, 9, 10, 11, 12),
                ),
            )
        assertThrows<IllegalArgumentException> { sut.buy(command) }
    }

    @Test
    fun `남은 금액으로 자동 로또를 발급한다`() {
        val payment = 3_000L
        val manualLotto =
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(7, 8, 9, 10, 11, 12),
            )
        val command = BuyLottoCommand(payment, manualLotto)

        val lotto = sut.buy(command)

        lotto.numberOfLines shouldBe 3
    }

    @Test
    fun `자동으로 로또를 발급한다`() {
        val numberOfLines = 5
        val lotto = sut.generateRandom(numberOfLines)
        lotto.numberOfLines shouldBe numberOfLines
    }

    @Test
    fun `로또 게임 결과를 구한다`() {
        val lotto =
            Lotto.from(
                // FIFTH
                LottoLine.from(1, 2, 3, 7, 8, 9),
                // FOURTH
                LottoLine.from(1, 2, 3, 4, 8, 9),
                // SECOND
                LottoLine.from(1, 2, 3, 4, 5, 7),
            )
        val winner = WinnerInfo(listOf(1, 2, 3, 4, 5, 6), 7)
        val command = PlayLottoCommand(lotto, winner, 3_000L)

        val result = sut.play(command)

        result.matchResult.get(Rank.SECOND) shouldBe 1
        result.matchResult.get(Rank.FOURTH) shouldBe 1
        result.matchResult.get(Rank.FIFTH) shouldBe 1
        result.matchResult.totalPrize shouldBe 30_055_000
        result.returnOnInvestment shouldBe (10_018.3333333 plusOrMinus 1e-6)
    }
}
