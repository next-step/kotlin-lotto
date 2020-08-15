package view

import model.Lotto
import model.LottoManual
import model.LottoNumber
import model.Money

object InputView {
    fun getMoney(): Money {
        println("구매금액을 입력해 주세요.")
        return Money(readLine())
    }

    fun getManualLottoCount(): LottoManual {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val inputString = readLine()
        checkNotNull(inputString)
        return LottoManual(inputString)
    }

    fun getManualLottoNumber(manual: LottoManual): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val list: MutableList<Lotto> = mutableListOf()
        repeat(manual.value) {
            val inputString = readLine()
            list.add(createLottoFromInput(inputString, true))
        }
        return list.toList()
    }

    fun getPrizeLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputString = readLine()
        return createLottoFromInput(inputString)
    }

    fun getBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val inputString = readLine()
        checkNotNull(inputString)
        require(inputString.isNotBlank()) { "not accept blank" }
        return inputString.toInt()
    }

    private fun createLottoFromInput(inputString: String?, isManual: Boolean = false): Lotto {
        checkNotNull(inputString)
        require(LOTT_REGEX.matches(inputString)) { "not accepted lotto regex" }
        val inputLottoNumbers = removeWhiteSpace(inputString)

        return Lotto(makeLottoNumber(inputLottoNumbers), isManual)
    }

    private fun makeLottoNumber(inputPrizeNumbers: String) =
        inputPrizeNumbers.split(DELIMITER).map { LottoNumber.from(it.toInt()) }.toSet()

    private fun removeWhiteSpace(inputString: String): String {
        return if (inputString.contains(" ")) {
            inputString.replace(" ", "")
        } else {
            inputString
        }
    }

    val LOTT_REGEX = Regex(pattern = "^[0-9,\\s]+\$")
    const val DELIMITER = ","
}
