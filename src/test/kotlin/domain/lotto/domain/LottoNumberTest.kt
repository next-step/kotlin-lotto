package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.assertAll

@DisplayName("로또(Lotto)")
class LottoNumberTest {

    @RepeatedTest(value = 45, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `1~45 사이의 숫자로 로또를 생성할 수 있다`(repetitionInfo: RepetitionInfo) {
        val lotto = LottoNumber.of(repetitionInfo.currentRepetition)

        assertAll(
            { assertThat(lotto).isNotNull },
            { assertThat(lotto).isExactlyInstanceOf(LottoNumber::class.java) },
        )
    }
}
