package lotto

class InputBonusNumberStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<ViewBonusNumber>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult {
        return try {
            println("보너스 볼을 입력해 주세요.")
            val bonusNumber = read()

            LottoResult.SuccessStep.InputBonusNumberStep(bonusNumber.toInt())
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }

    private fun read(): String {
        return inputProvider() ?: throw IllegalArgumentException("입력이 없습니다.")
    }
}
