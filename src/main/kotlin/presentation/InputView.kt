package presentation

import domain.lotto.Lotto
import domain.lotto.LottoNumber

class InputView {
    companion object {
        fun inputPurchaseAmount(): Int = readIntWithMessage("구입금액을 입력해 주세요.")

        fun inputPurchaseManualLotto(): Int = readIntWithMessage("수동으로 구매할 로또 수를 입력해 주세요.")

        fun inputManualLottoNumbers(count: Int): List<Lotto> {
            require(count >= 0) { "수동으로 구매할 로또 수는 음수일 수 없습니다. 입력한 수: $count" }

            if (count <= 0) return emptyList()

            println("수동으로 구매할 번호를 입력해주세요.")
            return List(count) { readLottoFromInput() }
        }

        fun inputWinningNumbers(): Lotto {
            println("지난 주 당첨번호를 입력해 주세요.")
            return readLottoFromInput()
        }

        fun inputBonusNumber(): Int = readIntWithMessage("보너스 볼을 입력해 주세요.")

        private fun readIntWithMessage(message: String): Int {
            println(message)
            return readln().toInt()
        }

        private fun readLottoFromInput(): Lotto =
            Lotto(
                readln()
                    .split(",")
                    .map { LottoNumber(it.trim().toInt()) }
                    .toSet(),
            )
    }
}
