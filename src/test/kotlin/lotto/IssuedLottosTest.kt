package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class IssuedLottosTest {
    @Test
    internal fun `발급받은 여러개의 로또에 당첨 번호를 비교했을때 번호가 몇개 일치하는지 알 수 있어야한현`() {
        // given : 당첨 번호와 발급받은 로또 준비
        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val issuedLottos = listOf(
            Lotto(setOf(1, 2, 3, 4, 5, 45)),
            Lotto(setOf(1, 2, 3, 4, 5, 45)),
            Lotto(setOf(1, 2, 3, 4, 44, 45)),
            Lotto(setOf(1, 2, 3, 43, 44, 45)),
        )
        val sut = IssuedLottos(issuedLottos)

        // when : 발급받은 로또를 당첨 번호와 비교해서 번호 일치 결과를 반환 받음
        val lottoResult = sut.check(winningLotto)

        lottoResult.threeMatchCount shouldBe 1
        lottoResult.fourMatchCount shouldBe 1
        lottoResult.fiveMatchCount shouldBe 2
        lottoResult.sixMatchCount shouldBe 0
    }
}
