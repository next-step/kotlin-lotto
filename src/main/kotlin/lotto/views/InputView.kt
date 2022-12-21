package lotto.views

object InputView {
    fun insertMoney(): String {
        println("구입금액을 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank()) { "구입 금액을 입력하셔야합니다." }
        return input
    }

    fun getManualLottoCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank()) { "구입 금액을 입력하셔야합니다." }
        return input
    }

    fun getManualLottos(count: Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        val lottos = mutableListOf<String>()

        while (lottos.size < count) {
            val input = readLine()
            require(!input.isNullOrBlank()) { "구입 금액을 입력하셔야합니다." }
            lottos.add(input)
        }

        return lottos
    }

    fun getWinningLottoNumbers(): String {
        println("지난 주 당첨번호를 입력해 주세요.")
        val winningNumbers = readLine()
        require(!winningNumbers.isNullOrBlank())
        return winningNumbers
    }

    fun getBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()
        require(!bonusNumber.isNullOrBlank())
        return bonusNumber
    }
}
