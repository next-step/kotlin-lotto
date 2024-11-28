package lotto

class InputBonusNumberStep(val inputProvider: () -> String? = { readln() }) : LottoViewStep<LottoNumber>() {
    override fun apply(lottoMachine: LottoMachine): LottoResult<LottoNumber> {
        return try {
            println("보너스 볼을 입력해 주세요.")
            val bonusNumber = read()

            val lottoNumber = lottoMachine.createLottoNumber(bonusNumber)
            LottoResult.SuccessStep.InputBonusNumberStep(lottoNumber)
        } catch (e: Exception) {
            LottoResult.Error.CustomError("입력 오류: ${e.message}")
        }
    }

    private fun read(): String {
        return inputProvider() ?: throw IllegalArgumentException("입력이 없습니다.")
    }
}
