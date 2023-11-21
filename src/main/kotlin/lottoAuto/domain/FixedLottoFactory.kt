package lottoAuto.domain

class FixedLottoFactory(private val numbers: List<List<Int>>) : LottoFactory {
    override fun create(lottoSize: Int): List<Lotto> {
        return numbers.map { Lotto(it.map { number -> number.toLottoNumber() }) }
    }
}
