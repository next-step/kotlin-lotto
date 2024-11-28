package lotto

class InputAmountStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<Amount>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult {
        return try {
            println("구입금액을 입력해 주세요:")

            val input = inputProvider() ?: throw IllegalArgumentException("Invalid input")
            LottoResult.SuccessStep.InputAmountStep(lottoMachine.createPay(input))
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }
}
