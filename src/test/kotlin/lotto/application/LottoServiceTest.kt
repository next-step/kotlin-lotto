package lotto.application

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoNumber
import lotto.domain.LottoPayment
import lotto.domain.Rank2
import lotto.domain.WinningLine
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoServiceTest {
    private lateinit var sut: LottoService

    @BeforeAll
    fun setUp() {
        sut = LottoService(RandomLottoLineGenerator())
    }

    @Test
    fun `남은 금액으로 자동 로또를 발급한다`() {
        val payment = LottoPayment.from(3_000L)
        val manualLotto =
            Lotto.from(
                LottoLine.from(1, 2, 3, 4, 5, 6),
                LottoLine.from(7, 8, 9, 10, 11, 12),
            )

        val lotto = sut.buy(BuyLottoCommand(payment, manualLotto))

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
        val winner =
            WinningLine(
                LottoLine.from(1, 2, 3, 4, 5, 6),
                LottoNumber.from(7),
            )

        val result = sut.play2(lotto, winner)

        result.get(Rank2.SECOND) shouldBe 1
        result.get(Rank2.FOURTH) shouldBe 1
        result.get(Rank2.FIFTH) shouldBe 1
        result.totalPrize shouldBe 30_055_000
    }
}
