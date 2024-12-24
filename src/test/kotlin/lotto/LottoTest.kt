package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    internal fun `로또 구매 금액은 0이거나 null이 아니어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(null)
        }
    }

    @Test
    internal fun `로또 구매 금액은 1000이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(999)
        }
    }

    @Test
    internal fun `로또 한 장의 금액은 1000원 이다`() {
        LottoVendingMachine.buyLotto(1000).size shouldBe 1
        LottoVendingMachine.buyLotto(14000).size shouldBe 14
    }

    @Test
    internal fun `로또 당첨 금액`() {
        Prize.FIRST.money shouldBe 2_000_000_000
        Prize.SECOND.money shouldBe 1_500_000
        Prize.THIRD.money shouldBe 50_000
        Prize.FOURTH.money shouldBe 5_000
        Prize.NONE.money shouldBe 0
    }

    @Test
    internal fun `일치하는 개수에 맞는 등수`() {
        Prize.from(6) shouldBe Prize.FIRST
        Prize.from(5) shouldBe Prize.SECOND
        Prize.from(4) shouldBe Prize.THIRD
        Prize.from(3) shouldBe Prize.FOURTH
        Prize.from(2) shouldBe Prize.NONE
        Prize.from(1) shouldBe Prize.NONE
        Prize.from(0) shouldBe Prize.NONE
    }

    @Test
    internal fun `로또 번호가 실제로 일치하는지`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(2, 4, 6, 8, 10, 12)

        lotto.countMatch(winningLotto) shouldBe 3
    }

    @Test
    internal fun `구매한 로또와 결과가 일치`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)

        val lottos = mutableListOf<Lotto>().apply {
            add(Lotto(8, 21, 23, 41, 42, 43))
            add(Lotto(3, 5, 11, 16, 32, 38))
            add(Lotto(7, 11, 16, 35, 36, 44))
            add(Lotto(1, 8, 11, 31, 41, 42))
            add(Lotto(13, 14, 16, 38, 42, 45))
            add(Lotto(7, 11, 30, 40, 42, 43))
            add(Lotto(2, 13, 22, 32, 38, 45))
            add(Lotto(23, 25, 33, 36, 39, 41))
            add(Lotto(1, 3, 5, 14, 22, 45))
            add(Lotto(5, 9, 38, 41, 43, 44))
            add(Lotto(2, 8, 9, 18, 19, 21))
            add(Lotto(13, 14, 18, 21, 23, 35))
            add(Lotto(17, 21, 29, 37, 42, 45))
            add(Lotto(3, 8, 27, 30, 35, 44))
        }

        val lottoResult = LottoLotteryMachine.draw(
            winningLotto,
            lottos
        )

        lottoResult.getFirstPrize().size shouldBe 0
        lottoResult.getSecondPrize().size shouldBe 0
        lottoResult.getThirdPrize().size shouldBe 0
        lottoResult.getFourthPrize().size shouldBe 1
        lottoResult.getNonePrize().size shouldBe 13
    }

    @Test
    internal fun `로또 번호는 6개 이다`() {
        val lottoNumbersSize = Lotto().lottoNumbers.size

        lottoNumbersSize shouldBe 6
    }

    @Test
    internal fun `로또 번호는 오름차순 이다`() {
        val lottoNumbers = Lotto().lottoNumbers

        lottoNumbers shouldBe lottoNumbers.sortedBy { it.number }
    }
}
