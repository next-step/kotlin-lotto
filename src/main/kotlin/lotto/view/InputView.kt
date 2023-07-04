package lotto.view

class InputView {
    companion object {
        fun purchaseMoney(): Long {
            println("구입금액을 입력해 주세요.")
            return readln().toLong()
        }

        fun winningLotto(): List<Int> {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return readln()
                .split(",")
                .map { it.toInt() }
                .toList()
        }

        fun bonusNumber(): Int {
            println("보너스 볼을 입력해 주세요.")
            return readln().toInt()
        }
    }
}
