package domain.lotto.domain

import domain.lotto.error.InvalidNumberOfMatchException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("순위(Rank)")
class RankTest {

    @ParameterizedTest(name = "당첨 갯수 = {0}, 보너스볼 필요 여부 = {1}")
    @CsvSource(
        value = [
            "0:true", "0:false", "1:true", "1:false", "2:true", "2:false",
            "3:true", "3:false", "4:true", "4:false", "5:true", "5:false", "6:true", "6:false"
        ],
        delimiter = ':'
    )
    fun `맞은 숫자와 보너스 필요 유무를 통해 생성한다`(matchOfNumber: Int, needBonusBall: Boolean) {
        val rank = Rank(matchOfNumber, needBonusBall)

        assertAll(
            { assertThat(rank).isNotNull },
            { assertThat(rank).isExactlyInstanceOf(Rank::class.java) }
        )
    }

    @ParameterizedTest(name = "당첨 갯수 = {0}, 보너스볼 필요 여부 = {1}")
    @CsvSource(
        value = ["${Lotto.MINIMUM_SIZE - 1}:true", "${Lotto.MINIMUM_SIZE - 1}:false", "${Lotto.MAXIMUM_SIZE + 1}:true", "${Lotto.MAXIMUM_SIZE + 1}:false"],
        delimiter = ':'
    )
    fun `맞은 숫자가 범위에 맞지 않다면 예외를 발생한다`(matchOfNumber: Int, needBonusBall: Boolean) {
        val exception = assertThrows<InvalidNumberOfMatchException> { Rank(matchOfNumber, needBonusBall) }

        assertThat(exception.message).isEqualTo(
            "맞은 로또의 개수 %s 은 ${Lotto.MINIMUM_SIZE} 과 ${Lotto.MAXIMUM_SIZE} 사이의 숫자가 아니다.".format(matchOfNumber)
        )
    }

    @ParameterizedTest(name = "당첨 갯수 = {0}, 보너스볼 필요 여부 = {1}, 사용 여부 및 기대값 = {2}")
    @CsvSource(
        value = ["0:true:true", "0:true:false", "1:true:true", "1:true:false",
            "2:true:true", "2:true:false", "3:true:true", "3:true:false",
            "4:true:true", "4:true:false", "5:true:true", "5:true:false", "6:true:true", "6:true:false"
        ],
        delimiter = ':'
    )
    fun `보너스 필요가 참이면 보너스 사용 여부를 그대로 반환한다`(matchOfNumber: Int, needBonusBall: Boolean, expected: Boolean) {
        val rank = Rank(matchOfNumber, needBonusBall)
        val actual = rank.isUseBonusBall(expected)

        assertThat(actual).isEqualTo(expected)
    }
}
