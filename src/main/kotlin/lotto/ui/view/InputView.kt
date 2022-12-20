package lotto.ui.view

import lotto.domain.LottoNumber

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")

        return readLine()?.toIntOrNull() ?: 0
    }

    fun getWinningLottoNumbers(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readLine()?.split(",")?.map { stringNumber ->
            LottoNumber.of(stringNumber.toInt())
        }?.toSet() ?: emptySet()
    }

    fun getBonusLottoNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")

        return LottoNumber.of(readLine()?.toIntOrNull() ?: -1)
    }
}
