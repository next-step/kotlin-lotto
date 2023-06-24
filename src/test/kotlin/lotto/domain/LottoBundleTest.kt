package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import lotto.test.FakeGenerator

class LottoBundleTest : BehaviorSpec({
    given("로또 당첨 번호가 1, 2, 3, 4, 5, 6이고 보너스 번호가 7이다.") {
        val lottoNumbers = FakeGenerator.lottoNumbers(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)
        val lottoWinningNumbers = LottoWinningNumbers.of(lottoNumbers, bonusNumber)

        `when`("lottoBundle이 [1, 2, 3, 4, 5, 6], [1, 2, 3, 14, 15, 16] 이다.") {
            val lotto1 = FakeGenerator.lotto(1, 2, 3, 4, 5, 6)
            val lotto2 = FakeGenerator.lotto(1, 2, 3, 14, 15, 16)
            val lottoBundle = LottoBundle(listOf(lotto1, lotto2))

            then("로또 결과는 1등, 5등이다.") {
                val lottoResult = lottoBundle.getLottoResult(lottoWinningNumbers)
                lottoResult.lottoRanks shouldContainExactly listOf(
                    LottoRank.FIRST,
                    LottoRank.FIFTH
                )
            }

        }
    }
})
