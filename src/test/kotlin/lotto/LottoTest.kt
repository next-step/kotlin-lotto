package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectLottos = (0 until expectSize).map { _ -> Lotto() }
        val sut = LottoMachine(lottoGenerator(expectLottos), money)

        val actualLottos = sut.issuedLottos

        assertThat(actualLottos).isEqualTo(expectLottos)
    }

    @Test
    fun `로또 번호 3개 일치 통계 추출`() {
        val expectLottos = (0 until 1).map { _ -> Lotto(1, 2, 3, 4, 5, 6) }
        val sut = LottoMachine(lottoGenerator(expectLottos), 1000)

        val actual = sut.issueStatistics(Lotto(1, 2, 3, 7, 8, 9))

        assertThat(actual).isEqualTo(Statistics(mapOf(3 to 1)))
    }

    private fun lottoGenerator(lottos: List<Lotto>): LottoGenerator {
        val expectedLotto = lottos.iterator()
        return LottoGenerator { expectedLotto.next() }
    }
}
