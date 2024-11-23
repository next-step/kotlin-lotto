package lotto.view

class InputView {
    companion object {
        fun getLottoMoney(): Int {
            println("구입 금액을 입력해주세요.")
            return readln().toInt()
        }

        fun getManualLottoCount(): Int {
            println("수동으로 구매할 로또 수를 입력해주세요.")
            return readln().toInt()
        }

        fun getManualNumbers(manualLottoCount: Int): List<Set<Int>> {
            println("수동으로 구매할 번호를 입력해주세요.")
            return (1..manualLottoCount).map {
                readln().split(",").map { it.toInt() }.toSet()
            }
        }

        fun getWinningLottoNumbers(): Set<Int> {
            println("지난 주 당첨 번호를 입력해주세요.")
            return readln().split(",").map { it.toInt() }.toSet()
        }

        fun getBonusNumber(): Int {
            println("보너스 볼을 입력해주세요.")
            return readln().toInt()
        }
    }
}
