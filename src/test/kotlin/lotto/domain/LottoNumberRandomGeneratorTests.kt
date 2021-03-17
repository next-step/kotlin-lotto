package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberRandomGeneratorTests {
    @Test
    fun `랜덤으로 생성되는 1~N까지 꽉 채우려면 N번 이상 호출되어야 한다`() {
        var callCount = 0
        val checkSet: MutableSet<Int> = mutableSetOf()
        val generator: LottoNumberGenerator = LottoNumberRandomGenerator(1, 5)
        while (checkSet.size < 5) {
            val number = generator.number

            checkSet.add(number)
            callCount++
        }

        assertThat(callCount)
            .isGreaterThanOrEqualTo(5)
        assertThat(checkSet)
            .containsExactlyInAnyOrder(
                1, 2, 3, 4, 5
            )
    }
}
