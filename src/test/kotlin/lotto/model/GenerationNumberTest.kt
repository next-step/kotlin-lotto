package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GenerationNumberTest {
    @Test
    @DisplayName("로또 번호 생성하는 메소드가 6자리 숫자를 반환하는지 확인")
    fun `check generate lotto list function`() {
        val list = (1..45).toList()

        val lottoNumbers = RandomNumberGenerationProcessor.generateNumbers(list)

        assertThat(lottoNumbers).hasSize(6)
    }

    @Test
    @DisplayName("로또 번호 생성하는 메소드의 숫자 범위를 6개 미만으로 입력한 경우")
    fun `incorrect lotto number range list`() {
        val list = (1..3).toList()

        assertThrows<IllegalArgumentException> {
            RandomNumberGenerationProcessor.generateNumbers(list)
        }
    }
}
