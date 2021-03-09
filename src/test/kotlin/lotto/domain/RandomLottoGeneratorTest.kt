package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomLottoGeneratorTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val randomLottoGenerator = RandomLottoGenerator()
        val result = randomLottoGenerator.generate()
        assertThat(result).isNotNull
    }

    @Test
    fun `로또 생성 시 랜덤한 로또를 생성한다`() {
        val randomLottoGenerator = RandomLottoGenerator()
        randomLottoGenerator.generate()
        randomLottoGenerator.generate()

        // TODO: 랜덤한 로또라는 걸 어떻게 검증할 수 있지 ?
    }
}
