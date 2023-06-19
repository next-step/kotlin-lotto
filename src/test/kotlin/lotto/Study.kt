package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Study {
    @Test
    fun shuffledStudy() {
        val lottoNumbers = (1..45).shuffled()
            .subList(0, 6)
            .sorted()
        assertThat(lottoNumbers.size).isEqualTo(6)
    }
}
