package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `count를 입력 받은만큼 랜덤 번호를 생성한다`() {
        val lottoGame = LottoGame.from(10)

        lottoGame.lottoNumbers.size shouldBe 10
    }
}
