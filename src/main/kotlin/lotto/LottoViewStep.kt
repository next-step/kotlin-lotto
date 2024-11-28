package lotto

typealias ViewAmount = Int
typealias ViewManual = List<List<Int>>
typealias ViewLastWeekNumbers = List<Int>
typealias ViewBonusNumber = Int

sealed class LottoViewStep<out T> {
    abstract fun apply(lottoMachine: LottoMachine): LottoResult
}
