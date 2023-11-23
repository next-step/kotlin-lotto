package lotto.view

object TextResource {
    const val ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    const val ENTER_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요."
    const val ENTER_LAST_WINNER_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    const val LOTTO_RESULT = "당첨 통계\n---------"
    fun resultByRank(
        countOfMatch: Int,
        isMatchBonus: Boolean,
        winningMoney: Int,
        rankCount: Int,
    ) = "${countOfMatch}개 일치".let { text ->
        if (isMatchBonus) {
            "$text, 보너스 볼 일치"
        } else {
            "$text "
        }
    }.let { text ->
        "$text(${winningMoney}원)- ${rankCount}개"
    }

    fun countOfPurchasedLottery(
        manualCount: Int,
        autoCount: Int,
    ) = "수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다."

    fun total_return_rate(
        returnRate: Double,
    ) = "총 수익률은 ${returnRate}입니다.${if (returnRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}"
}

