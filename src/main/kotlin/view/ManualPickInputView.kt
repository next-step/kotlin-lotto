package view

object ManualPickInputView {
    fun receiveManualPick() {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readLine()!!.toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val LottoNumberParsedResult = readLottoNumbers()
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
