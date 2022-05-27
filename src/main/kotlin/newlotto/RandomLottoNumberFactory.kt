package newlotto

interface LottoNumberFactory {
    fun generate(): Lotto
}

class RandomLottoNumberFactory: LottoNumberFactory {
    override fun generate(): Lotto {
        return Lotto((1..LottoInformation.normalLottoNumberSize).map {
            LottoInformation.normalLottoNumberRange.random()
        })
    }
}
