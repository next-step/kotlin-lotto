package lottoAuto.domain
interface LottoFactory {
    fun create(lottoSize: Int): List<Lotto>
}
