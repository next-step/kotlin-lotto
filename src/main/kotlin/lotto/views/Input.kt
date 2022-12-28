package lotto.views

import lotto.LottoNumbers

object Input {
    fun getPriceForBuying(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("It is not a number")
    }

    fun getWinnerLottoNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(",")?.map { it.toInt() }
            ?: throw IllegalArgumentException("It is not a number")
    }
}
