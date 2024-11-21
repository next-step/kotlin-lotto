package lotto.application

import io.kotest.matchers.shouldBe
import lotto.domain.RandomLottoLineGenerator
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
        val lotto = sut.generateRandom(5)
        lotto.numberOfLines shouldBe 5
    }
}
