package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultHandlerTest : StringSpec ({

    "사용자가 구매한 로또 번호와 당첨 번호가 완전히 일치하면 1등이 된다." {
        // Arrange:
        val lottoNumbers = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val userLottos = listOf(lottoNumbers)

        val bonusNumber = LottoNumber(7)
        val winningNumbers = WinningNumbers(lottoNumbers, bonusNumber)

        // Act:
        val result = LottoResultHandler.match(userLottos, winningNumbers)

        // Assert:
        result.results[0].lottoRank shouldBe LottoRank.FIRST
    }

    "사용자가 구매한 로또 번호와 당첨 번호가 한 개도 일치하지 않으면 꽝이다." {
        // Arrange:
        val userLotto = listOf(
            LottoNumbers(
                listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
            )
        )
        val bonusNumber = LottoNumber(7)
        val winningNumbers = WinningNumbers(
            LottoNumbers(listOf(8, 9, 10, 11, 12, 13).map { LottoNumber(it) }),
            bonusNumber
        )

        // Act:
        val result = LottoResultHandler.match(userLotto, winningNumbers)

        // Assert:
        result.results.first { it.lottoRank == LottoRank.NONE }.count.value shouldBe 1
        result.results.filter { it.lottoRank != LottoRank.NONE }.all { it.count.value == 0 } shouldBe true
    }
})