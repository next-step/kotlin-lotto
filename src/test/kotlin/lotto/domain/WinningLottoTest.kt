package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : DescribeSpec ({
    describe("당첨 로또 테스트") {
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()
        val lotto = Lotto(lottoNumbers)

        it("보너스 번호가 당첨번호가 중첩될 경우 IllegalArgumentException가 throw가 된다.") {
            val bonusNumber = LottoNumber.of(1)

            shouldThrow<IllegalArgumentException> {
                WinningLotto(lotto, bonusNumber)
            }
        }

        it("6개의 당첨번호와 1개의 보너스 번호를 통해 당첨 로또를 생성할 수 있다.") {
            val bonusNumber = LottoNumber.of(10)

            WinningLotto(lotto, bonusNumber)
        }

        it("특정 로또의 랭킹이 몇등인지 계산할 수 있다.") {
            val bonusNumber = LottoNumber.of(10)
            val winningLotto = WinningLotto(lotto, bonusNumber)

            val otherLottoNumbers = (3..8).map { LottoNumber.of(it) }.toSet()
            val otherLotto = Lotto(otherLottoNumbers)

            winningLotto.match(otherLotto) shouldBe Rank.FOURTH
        }
    }
})