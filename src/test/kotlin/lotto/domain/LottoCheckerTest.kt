package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoCheckerTest : BehaviorSpec({
    given("로또리스트와 당첨번호가 주어졌다") {
        val lottos = Lottos(
            listOf(
                Lotto((LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toSortedSet()), // 1등
                Lotto((LottoNumber.LOTTO_MIN_NUMBER + 1 until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE + 1).toSortedSet()), // 2등
                Lotto((LottoNumber.LOTTO_MIN_NUMBER + 2 until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE + 2).toSortedSet()), // 3등
                Lotto((LottoNumber.LOTTO_MIN_NUMBER + 3 until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE + 3).toSortedSet()), // 4등
                Lotto((LottoNumber.LOTTO_MIN_NUMBER + 4 until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE + 4).toSortedSet()), // 낙첨
            )
        )
        val winNumbers =
            WinNumbers(
                Lotto((LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toSet()),
                LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE + 1
            )
        `when`("당첨결과를 확인했을때") {
            then("정확한 결과가 반환된다") {
                LottoChecker.checkResult(lottos, winNumbers) shouldBe LottoResults.of(
                    mapOf(
                        WinningPrize.FIRST to 1,
                        WinningPrize.SECOND to 1,
                        WinningPrize.THIRD to 1,
                        WinningPrize.FOURTH to 1,
                    ),
                    5000
                )
            }
        }
    }
})
