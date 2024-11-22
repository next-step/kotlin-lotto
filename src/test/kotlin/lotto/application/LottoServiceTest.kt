package lotto.application

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.RandomLottoLineGenerator
import lotto.domain.Rank
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
    fun `자동으로 로또를 발급한다`() {
        val numberOfLines = 5
        val lotto = sut.generateRandom(numberOfLines)
        lotto.numberOfLines shouldBe numberOfLines
    }

    @Test
    fun `로또 게임 결과를 구한다`() {
        val lotto =
            Lotto.from(
                LottoLine.from(1, 2, 3, 7, 8, 9),
                LottoLine.from(1, 2, 3, 4, 8, 9),
            )
        val winner = LottoLine.from(1, 2, 3, 4, 5, 6)

        val result = sut.play(lotto, winner)

        result.get(Rank.FOURTH) shouldBe 1
        result.get(Rank.FIFTH) shouldBe 1
        result.totalPrize shouldBe 55_000
    }
}
