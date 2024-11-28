package lotto

object InputView {
    fun getUserAmount(): Amount {
        val userAmount = readMessage("구입금액을 입력해 주세요.").toInt()
        return Amount(userAmount)
    }

    fun getLastWeekNumbers(lottoMachine: LottoMachine): Lotto {
        val numbers = readCsvToInt("지난 주 당첨 번호를 입력해 주세요.")
        return lottoMachine.createLotto(numbers)
    }

    fun getBonusNumber(lottoMachine: LottoMachine): LottoNumber {
        val bonusNumber = readMessage("보너스 볼을 입력해 주세요.")
        return lottoMachine.createLottoNumber(bonusNumber)
    }

    fun getManualLotto(lottoMachine: LottoMachine): Lottos {
        val manualLottoCount = readMessage("수동으로 구매할 로또 수를 입력해 주세요.").toInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return Lottos(
            List(manualLottoCount) {
                getManualLottoCount(lottoMachine)
            },
        )
    }

    private fun getManualLottoCount(lottoMachine: LottoMachine): Lotto {
        val number = readCsvToInt()
        return lottoMachine.createLotto(number)
    }

    private fun readMessage(message: String): String {
        println(message)
        return readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    private fun readCsvToInt(message: String? = null): List<Int> {
        if (message != null) {
            println(message)
        }
        val input = readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")

        return input.split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 값: '$it'. 입력은 ','로 구분된 숫자여야 합니다.")
            }
    }
}
