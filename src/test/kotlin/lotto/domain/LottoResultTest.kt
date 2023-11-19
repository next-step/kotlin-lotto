package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoResultTest {

    @DisplayName("일치하는 숫자에 따라 로또 결과와 당청금을 반환한다")
    @ParameterizedTest
    @CsvSource(value = [
        "6, 2_000_000_000",
        "5, 1_500_000",
        "4, 50_000",
        "3, 5_000",
        "2, 0",
        "1, 0",
        "0, 0",
    ])
    fun resultShouldBeReturn(countOfMatch: Int, price: Int) {
        val lottoResult = LottoResult.of(countOfMatch)
        assertThat(lottoResult.price).isEqualTo(price)
    }

    @DisplayName("일치하는 숫자가 유효하지 않은 경우 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun exceptionShouldBeThrowWhenCountOfMatchIsInvalid(countOfMatch: Int) {
        assertThatThrownBy { LottoResult.of(countOfMatch) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 숫자입니다")
    }
}