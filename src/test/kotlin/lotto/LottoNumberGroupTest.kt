package lotto

import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberGroupTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "1,2,3,4,5"])
    fun `로또 번호 6자리 유효성 체크`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumberGroup.of(input)
        }
    }
}

class LottoNumberGroup(private val numbers: Set<LottoNumber>) {

    companion object {
        private const val NUMBER_COUNT = 6

        fun of(stringOfNumbers: String): LottoNumberGroup {
            val lottoNumberGroup = LottoNumberGroup(
                stringOfNumbers
                    .split(",")
                    .map { LottoNumber(it) }
                    .toSet()
            )
            require(lottoNumberGroup.numbers.size == NUMBER_COUNT) { "유효하지 않은 로또입니다." }
            return lottoNumberGroup
        }
    }
}
