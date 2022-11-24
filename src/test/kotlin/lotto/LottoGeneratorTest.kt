package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 생성기의 Range 는 1부터 45의 범위를 가진다`() {
        assertThat(LottoGenerator().range.first).isEqualTo(1)
        assertThat(LottoGenerator().range.last).isEqualTo(45)
    }

    @Test
    fun `서로 같지않은 길이 6의 정수 배열을 반환하는 generatorLotto 메소드 생성`() {
        var lottoNumbers = LottoGenerator().generate()
        assertThat(lottoNumbers.size).isEqualTo(6)
        assertThat(lottoNumbers.toSet().size).isEqualTo(6)
    }
}
