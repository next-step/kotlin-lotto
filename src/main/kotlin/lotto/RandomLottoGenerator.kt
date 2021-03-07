package lotto

class RandomLottoGenerator {

    fun generate(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
