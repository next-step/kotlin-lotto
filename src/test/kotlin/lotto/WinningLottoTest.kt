package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({

    "6개의 번호가 일치하면 1등으로 상금은 20억이다." { // 부럽다..
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), LottoRanking.FIRST),
            row(listOf(10, 21, 34, 37, 42, 45), listOf(10, 21, 34, 37, 42, 45), LottoRanking.FIRST),
        ) { winningNumbers: List<Int>, lottoNumbers: List<Int>, expect: LottoRanking ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTicket = LottoTicket(lottoNumbers)

            val lottoRanking = winningLotto.checkRanking(lottoTicket)
            lottoRanking shouldBe expect
            lottoRanking.prize shouldBe 2_000_000_000
        }
    }

    "5개의 번호가 일치하면 2등으로 상금은 150만원이다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 45), LottoRanking.SECOND),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 45, 6), LottoRanking.SECOND),
        ) { winningNumbers: List<Int>, lottoNumbers: List<Int>, expect: LottoRanking ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTicket = LottoTicket(lottoNumbers)

            val lottoRanking = winningLotto.checkRanking(lottoTicket)
            lottoRanking shouldBe expect
            lottoRanking.prize shouldBe 1_500_000
        }
    }

    "4개의 번호가 일치하면 3등으로 상금은 5만원이다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 44, 45), LottoRanking.THIRD),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 44, 45, 6), LottoRanking.THIRD),
        ) { winningNumbers: List<Int>, lottoNumbers: List<Int>, expect: LottoRanking ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTicket = LottoTicket(lottoNumbers)

            val lottoRanking = winningLotto.checkRanking(lottoTicket)
            lottoRanking shouldBe expect
            lottoRanking.prize shouldBe 50_000
        }
    }

    "3개의 번호가 일치하면 4등으로 상금은 5천원이다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 43, 44, 45), LottoRanking.FOURTH),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 43, 44, 45, 6), LottoRanking.FOURTH),
        ) { winningNumbers: List<Int>, lottoNumbers: List<Int>, expect: LottoRanking ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTicket = LottoTicket(lottoNumbers)

            val lottoRanking = winningLotto.checkRanking(lottoTicket)
            lottoRanking shouldBe expect
            lottoRanking.prize shouldBe 5_000
        }
    }

    "3개 미만의 번호가 일치하면 낙첨으로 상금은 없다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 42, 43, 44, 45), LottoRanking.MISS),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 41, 42, 43, 44, 45), LottoRanking.MISS),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(40, 41, 42, 43, 44, 45), LottoRanking.MISS),
        ) { winningNumbers: List<Int>, lottoNumbers: List<Int>, expect: LottoRanking ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTicket = LottoTicket(lottoNumbers)

            val lottoRanking = winningLotto.checkRanking(lottoTicket)
            lottoRanking shouldBe expect
            lottoRanking.prize shouldBe 0
        }
    }
})
