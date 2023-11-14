package lottery.domain

class ManualLottoMachine {
    companion object {
        fun createLottos(inputManualLottos: List<String>): List<Lotto> {
            return inputManualLottos.map {
                Lotto.of(it.split(",").map { it.toInt() })
            }
        }
    }
}
