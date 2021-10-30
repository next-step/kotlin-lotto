package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberRangeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또(Lotto)")
class LottoNumberTest {

    @RepeatedTest(value = 45, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `1~45 사이의 숫자로 로또 번호를 생성할 수 있다`(repetitionInfo: RepetitionInfo) {
        val lottoNumber = LottoNumber.of(repetitionInfo.currentRepetition)

        assertAll(
            { assertThat(lottoNumber).isNotNull },
            { assertThat(lottoNumber).isExactlyInstanceOf(LottoNumber::class.java) },
        )
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = [0, -1, -10, -100, Integer.MIN_VALUE, 46, Integer.MAX_VALUE])
    fun `0이하 또는 46이상의 숫자는 로또 번호를 생성할 수 없다`(lottoNumber: Int) {
        val exception = assertThrows<InvalidLottoNumberRangeException> { LottoNumber.of(lottoNumber) }

        assertThat(exception.message).isEqualTo("%s는 LottoNumber 의 범위를 벗어난 값입니다.".format(lottoNumber))
    }
}
