package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomLottoPickerTest {

    @Test
    fun `서로 다른 랜덤한 로또 번호를 6개 생성한다`() {
        // given
        val randomLottoPicker = RandomLottoPicker()

        // when
        val result = randomLottoPicker.pick()

        // then
        assertAll(
            { assertThat(result).hasSize(6) },
            { assertThat(result).doesNotHaveDuplicates() }
        )
    }
}
