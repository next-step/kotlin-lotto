package view.manualpick

import view.InvalidManualNumbers
import view.LottoNumberParser
import view.ParsedManualNumbers

object ManualPickInputView {
    fun receiveManualPick(): ManualPickInput {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = ManualPickCountParser.parse(readLine()!!)

        if (count < 1) {
            return ManualPickInput(emptyList())
        }

        println("수동으로 구매할 번호를 입력해 주세요.")
        val results = (1..count).map { readLottoNumbers() }
        return ManualPickInput(results)
    }

    private tailrec fun readLottoNumbers(): ParsedManualNumbers {
        val input = readLine()!!
        return when (val result = LottoNumberParser.parse(input)) {
            is ParsedManualNumbers -> return result
            is InvalidManualNumbers -> {
                println(result.message)
                readLottoNumbers()
            }
        }
    }
}
