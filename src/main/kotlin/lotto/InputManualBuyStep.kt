package lotto

class InputManualBuyStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<ViewManual>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult {
        return try {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            val manualLottoCount = read().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
            println("수동으로 구매할 번호를 입력해 주세요.")

            LottoResult.SuccessStep.InputManualStep(createManualLottos(manualLottoCount) { readCsvToInt() })
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }

    private fun createManualLottos(
        manualLottoCount: Int,
        apply: () -> List<Int>,
    ): ViewManual {
        return List(manualLottoCount) {
            apply()
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
