package lottery.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    @DisplayName("로또 갯수와 로또 생성 규칙을 전달하여 로또 번호 리스트를 가지는 객체를 생성한다")
    fun create_lotto_list() {
        val result = Lottos.of(5, RandomNumberGenerator())

        result.lottos.size shouldBe 5
    }
}
