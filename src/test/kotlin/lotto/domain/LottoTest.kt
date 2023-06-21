package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName(value = "로또는 중복되지 않은 1~45 사이 숫자 6개로 구성된다.")
    @Test
    fun lottoNumberValid() {
        val numList1 = listOf(3, 5, 7, 10, 25, 3)
        val numList2 = listOf(3, 5, 7, 10, 25, 47)
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Lotto(numList1.map { LottoNumber(it) }) }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Lotto(numList2.map { LottoNumber(it) }) }
    }

    @DisplayName(value = "정수 리스트로 생성한 로또를 오름차순으로 출력한다.")
    @Test
    fun printLotto() {
        val numList = listOf(3, 5, 7, 10, 25, 1)
        val lotto = Lotto(numList.map { LottoNumber(it) })
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 3, 5, 7, 10, 25]")
    }

    @DisplayName(value = "당첨 번호와 일치하는 갯수를 반환할 수 있다.")
    @Test
    fun winningCount() {
        val winningNums = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val numList = listOf(5, 6, 7, 8, 9, 10)
        val lotto = Lotto(numList.map { LottoNumber(it) })
        Assertions.assertThat(lotto.numOfMatch(winningNums)).isEqualTo(2)
    }
}