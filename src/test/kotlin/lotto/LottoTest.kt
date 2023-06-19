package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName(value = "정수 리스트로 생성한 로또를 오름차순으로 출력한다.")
    @Test
    fun printLotto() {
        val numList = listOf(3, 5, 7, 10, 25, 1)
        val lotto = Lotto(numList)
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 3, 5, 7, 10, 25]")
    }
}