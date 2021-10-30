package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.assertAll

@DisplayName("로또(Lotto)")
class LottoTest {

    @RepeatedTest(value = 45, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    fun `1~45 사이의 숫자로 로또를 생성할 수 있다`(repetitionInfo: RepetitionInfo) {
        val lotto = Lotto(repetitionInfo.currentRepetition)

        assertAll(
            { assertThat(lotto).isNotNull },
            { assertThat(lotto).isExactlyInstanceOf(Lotto::class.java) },
        )
    }
}
