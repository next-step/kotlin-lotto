package lotto

fun main() {
    val steps: List<LottoViewStep<*>> =
        listOf(
            InputAmountStep(),
            InputManualBuyStep(),
            InputLastWeekNumbersStep(),
            InputBonusNumberStep(),
        )

    val gameContext = GameContext()
    for (step in steps) {
        if (stepApply(step, gameContext)) break
    }
}

private fun stepApply(
    step: LottoViewStep<*>,
    gameContext: GameContext,
): Boolean {
    try {
        when (val result = step.apply(gameContext.lottoMachine)) {
            is LottoResult.SuccessStep.InputAmountStep -> {
                gameContext.pay(result.amount)
            }

            is LottoResult.SuccessStep.InputManualStep -> {
                gameContext.buyManualLottos(result.manual)
                gameContext.buyAutoLotto(gameContext.generator())
                ResultView.printBoughtLotto(gameContext.user)
            }

            is LottoResult.SuccessStep.InputLastWeekNumbersStep -> {
                gameContext.setLastWeekNumbers(result.lastWeekNumbers)
            }

            is LottoResult.SuccessStep.InputBonusNumberStep -> {
                val lottoStatistics = gameContext.statistics(result.bonusNumber)
                ResultView.printStatistics(lottoStatistics)
            }

            is LottoResult.Error -> {
                println("에러 발생: ${result.message}")
                return true // 에러 발생 시 중단
            }
        }
    } catch (e: Exception) {
        println("에러 발생: ${e.message}")
        return true
    }

    return false
}
