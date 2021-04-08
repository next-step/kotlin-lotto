package lotto.view

object InputView {

    fun inputPayment(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }

    fun inputHandwritingCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }

    fun inputLottoNumbers(handwritingCount: Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..handwritingCount).map {
            readLine() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
        }
    }

    fun inputWinnerNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(",")?.map { it.trim().toInt() } ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }
}
