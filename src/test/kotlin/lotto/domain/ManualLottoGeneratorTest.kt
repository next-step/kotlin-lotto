package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ManualLottoGeneratorTest {

    @Test
    fun `수동으로 입력한 로또를 발행`() {
        val sut = ManualLottoGenerator(
            createStubLottoGenerator(),
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(6, 5, 4, 3, 2, 1),
        )

        val actual = (0 until 2).map { sut.generate() }

        assertThat(actual)
            .contains(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(6, 5, 4, 3, 2, 1),
            )
    }

    @Test
    fun `수동으로 입력한 로또를 넘어서면 자동으로 발행`() {
        val sut = ManualLottoGenerator(
            createStubLottoGenerator(Lotto(11, 12, 13, 14, 15, 16)),
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(6, 5, 4, 3, 2, 1)
        )

        val actual = (0 until 3).map { sut.generate() }

        assertThat(actual)
            .contains(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(6, 5, 4, 3, 2, 1),
                Lotto(11, 12, 13, 14, 15, 16)
            )
    }

    private fun createStubLottoGenerator(vararg lottos: Lotto): LottoGenerator {
        val lottoIterator = lottos.iterator()
        return LottoGenerator { lottoIterator.next() }
    }
}
