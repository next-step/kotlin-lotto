package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberRangeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

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

    @RepeatedTest(value = 45, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `0이하의 숫자는 로또 번호를 생성할 수 없다`(repetitionInfo: RepetitionInfo) {
        val lottoNumber = repetitionInfo.currentRepetition - 45
        val exception = assertThrows<InvalidLottoNumberRangeException> { LottoNumber.of(lottoNumber) }

        assertThat(exception.message).isEqualTo("%s는 LottoNumber 의 범위를 벗어난 값입니다.".format(lottoNumber))
    }

    @RepeatedTest(value = 45, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `0이하 또는 46이상의 숫자는 로또 번호를 생성할 수 없다`(repetitionInfo: RepetitionInfo) {
        val lottoNumber = repetitionInfo.currentRepetition + 45
        val exception = assertThrows<InvalidLottoNumberRangeException> { LottoNumber.of(lottoNumber) }

        assertThat(exception.message).isEqualTo("%s는 LottoNumber 의 범위를 벗어난 값입니다.".format(lottoNumber))
    }

    @RepeatedTest(value = 45, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `1~45 사이의 숫자로 생성된 로또 번호는 서로 같다`(repetitionInfo: RepetitionInfo) {
        val expected = LottoNumber.of(repetitionInfo.currentRepetition)
        val actual = LottoNumber.of(repetitionInfo.currentRepetition)

        assertAll(
            { assertThat(actual).isEqualTo(expected) },
            { assertThat(actual).hasSameHashCodeAs(expected) },
        )
    }

    @Test
    fun `1~45 사이의 모든 로또번호를 반환한다`() {
        val expected = (1..45).associateWith { i -> LottoNumber.of(i) }.values.toSortedSet()

        val lottoNumbers: Set<LottoNumber> = LottoNumber.values()
        assertThat(lottoNumbers).containsAll(expected)
    }
}
