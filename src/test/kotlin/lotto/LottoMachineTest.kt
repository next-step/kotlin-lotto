package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectLottos = (0 until expectSize).map { _ -> Lotto() }
        val sut = LottoMachine(lottoGenerator(expectLottos), money)

        val actualLottos = sut.issuedLottos

        assertThat(actualLottos).isEqualTo(expectLottos)
    }

    @Test
    fun `여러 개의 로또 통계 추출`() {
        val expectLottos = listOf(
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 7),
            Lotto(1, 2, 3, 4, 7, 8),
            Lotto(1, 2, 3, 7, 8, 9),
            Lotto(1, 2, 3, 7, 8, 9),
        )
        val sut = LottoMachine(lottoGenerator(expectLottos), 6000)

        val actual = sut.issueStatistics(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Statistics(mapOf(6 to 2, 5 to 1, 4 to 1, 3 to 2)))
    }

    private fun lottoGenerator(lottos: List<Lotto>): LottoGenerator {
        val expectedLotto = lottos.iterator()
        return LottoGenerator { expectedLotto.next() }
    }
}
