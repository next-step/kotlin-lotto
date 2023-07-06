package lotto.view

object InputView {
    fun purchaseMoney(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLong()
    }

    fun manualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun manualLotto(): List<Int> {
        return readln()
            .split(",")
            .map { it.toInt() }
            .toList()
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
