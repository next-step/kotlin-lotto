package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectedLotto = (0 until expectSize).map { _ -> Lotto() }.iterator()
        val lottoGenerator = LottoGenerator { expectedLotto.next() }
        val sut = LottoMachine(lottoGenerator)

        val actual = sut.create(money)

        assertThat(actual).hasSize(expectSize)
    }
}
