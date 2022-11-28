package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStatTest : StringSpec({
    "로또 통계는 당첨등급에 따른 통계를 계산한다" {
        // given
        val lottoStat = LottoStat(
            listOf(LottoGrade.FIST_GRADE, LottoGrade.BOOM, LottoGrade.BASIC_GRADE, LottoGrade.BASIC_GRADE),
            14000
        )
        // when
        val gradeStat = lottoStat.gradeStat
        // then
        gradeStat shouldBe mapOf(
            LottoGrade.BASIC_GRADE to 2,
            LottoGrade.THIRD_GRADE to 0,
            LottoGrade.SECOND_GRADE to 0,
            LottoGrade.SECOND_PLUS_GRADE to 0,
            LottoGrade.FIST_GRADE to 1
        )
    }

    "로또 통계는 수익률을 계산한다" {
        // given
        val lottoStat = LottoStat(
            listOf(LottoGrade.BOOM, LottoGrade.BOOM, LottoGrade.BASIC_GRADE, LottoGrade.BOOM),
            14000
        )
        // when
        val winningRate = lottoStat.winningRate
        val winningMessage = lottoStat.winningMessage()
        // then
        winningRate.toDouble() shouldBe 0.35
        winningMessage shouldBe "손해"
    }
})
