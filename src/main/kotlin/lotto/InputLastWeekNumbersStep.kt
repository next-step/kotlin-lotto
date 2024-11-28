package lotto

class InputLastWeekNumbersStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<Lotto>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult<Lotto> {
        return try {
            println("지난 주 당첨 번호를 입력해 주세요.")
            val numbers = readCsvToInt()

            val lastWeekNumbers = lottoMachine.createLotto(numbers)
            LottoResult.SuccessStep.InputLastWeekNumbersStep(lastWeekNumbers)
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }

    private fun readCsvToInt(): List<Int> {
        return read().split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 값: '$it'. 입력은 ','로 구분된 숫자여야 합니다.")
            }
    }

    private fun read(): String {
        return inputProvider() ?: throw IllegalArgumentException("입력이 없습니다.")
    }
}
