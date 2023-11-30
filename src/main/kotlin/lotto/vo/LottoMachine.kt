package lotto.vo

class LottoMachine(buyPrice: Long = 0L) {
    val buyPrice: Long = buyPrice
    fun createLotto(): AutoLotto {
        return AutoLotto(buyPrice)
    }

    fun createManualLotto(inputString: List<String>): List<ManualLotto> {
        val manualLottoList = mutableListOf<ManualLotto>()
        for (input in inputString) {
            require(input.split(",").size == 6) { "로또 번호는 6개여야 합니다." }
            val lottoNumber = LottoNumber.of(input.split(","))
            val manualLotto = ManualLotto().addLottoNumbers(lottoNumber)
            manualLottoList.add(manualLotto)
        }
        return manualLottoList
    }

    fun calculateAutoLottoCount(manualLottoCount: Long): Long {
        return (buyPrice - (manualLottoCount * 1000L)) / 1000L
    }

    fun calculateAutoLottoBuyPrice(manualLottoCount: Long): Long {
        return (buyPrice - (manualLottoCount * 1000L))
    }

    fun createAutoLotto(count: Long): List<AutoLotto> {
        val autoLottoList = mutableListOf<AutoLotto>()
        for (i in 1..count) {
            val autoLotto = AutoLotto(buyPrice)
            autoLottoList.add(autoLotto)
        }
        return autoLottoList
    }
}
