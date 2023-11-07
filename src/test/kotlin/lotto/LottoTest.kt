package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectLottos = (0 until expectSize).map { _ -> Lotto() }
        val sut = LottoMachine(lottoGenerator(expectLottos))

        val actual = sut.create(money)

        assertThat(actual).isEqualTo(expectLottos)
    }

    private fun lottoGenerator(lottos: List<Lotto>): LottoGenerator {
        val expectedLotto = lottos.iterator()
        return LottoGenerator { expectedLotto.next() }
    }
}
