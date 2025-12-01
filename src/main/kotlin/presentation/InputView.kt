package presentation

import domain.Lotto
import domain.LottoNumber

class InputView {
    companion object {
        fun inputPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            return readln().toInt()
        }

        fun inputPurchaseManualLotto(): Int {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            return readln().toInt()
        }

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

        private fun readLottoFromInput(): Lotto =
            Lotto(
                readln()
                    .split(",")
                    .map { LottoNumber(it.trim().toInt()) }
                    .toSet(),
            )
    }
}
