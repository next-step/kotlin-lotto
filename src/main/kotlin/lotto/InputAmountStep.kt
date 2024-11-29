package lotto

class InputAmountStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<ViewAmount>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult {
        return try {
            println("구입금액을 입력해 주세요:")

            val input = inputProvider() ?: throw IllegalArgumentException("Invalid input")
            LottoResult.SuccessStep.InputAmountStep(input.toInt())
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }
}
