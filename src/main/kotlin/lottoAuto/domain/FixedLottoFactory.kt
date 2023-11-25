package lottoAuto.domain

class FixedLottoFactory(private val numbers: List<List<Int>>) : LottoFactory {
    override fun create(lottoSize: Int): List<Lotto> {
        require(lottoSize == numbers.size) { "수동으로 구매할 로또의 개수와 입력한 로또의 개수가 일치하지 않습니다" }
        return numbers.map { Lotto(it.map { number -> number.toLottoNumber() }) }
    }
}
