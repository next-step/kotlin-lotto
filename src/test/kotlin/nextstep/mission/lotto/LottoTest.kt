package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import nextstep.mission.lotto.fixture.lottoNumberListOf
import nextstep.mission.lotto.fixture.lottoNumbersListOf
import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningPrize.FIFTH
import nextstep.mission.lotto.vo.WinningPrize.FIRST
import nextstep.mission.lotto.vo.WinningPrize.FOURTH
import nextstep.mission.lotto.vo.WinningPrize.SECOND
import nextstep.mission.lotto.vo.WinningPrize.THIRD
import nextstep.mission.lotto.vo.WinningResult

class LottoTest : StringSpec({

    "당첨번호를 입력받아 통계를 반환한다." {
        val lottoNumbersList: List<LottoNumbers> = lottoNumbersListOf(
            listOf(1, 2, 3, 4, 5, 6), // 6 matched
            listOf(1, 2, 3, 4, 5, 45), // 5 matched & bonus matched
            listOf(1, 2, 3, 4, 5, 44), // 5 matched & bonus not matched
            listOf(1, 2, 3, 4, 15, 16), // 4 matched
            listOf(1, 2, 3, 14, 15, 16), // 3 matched
            listOf(11, 12, 13, 14, 15, 16), // no matched
        )
        val lottos = Lotto(lottoNumbersList)

        val winningNumbers = LottoNumbers(lottoNumberListOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(45)

        lottos.matchWinningNumbers(winningNumbers, bonusNumber) shouldBe WinningResult(
            mapOf(
                FIRST to 1,
                SECOND to 1,
                THIRD to 1,
                FOURTH to 1,
                FIFTH to 1,
            )
        )
    }

    "로또 두개를 합칠 수 있다." {
        val lottoNumbersList1: List<LottoNumbers> = lottoNumbersListOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 45),
            listOf(1, 2, 3, 4, 5, 44),
        )
        val lottos1 = Lotto(lottoNumbersList1)

        val lottoNumbersList2: List<LottoNumbers> = lottoNumbersListOf(
            listOf(1, 2, 3, 4, 15, 16),
            listOf(1, 2, 3, 14, 15, 16),
            listOf(11, 12, 13, 14, 15, 16)
        )
        val lottos2 = Lotto(lottoNumbersList2)

        lottos1 + lottos2 shouldBe Lotto(
            lottoNumbersListOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 45),
                listOf(1, 2, 3, 4, 5, 44),
                listOf(1, 2, 3, 4, 15, 16),
                listOf(1, 2, 3, 14, 15, 16),
                listOf(11, 12, 13, 14, 15, 16)
            )
        )
    }
})
